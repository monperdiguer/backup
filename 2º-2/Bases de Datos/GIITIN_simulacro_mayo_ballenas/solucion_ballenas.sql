/*
 Solucion simulacro mayo - Base de datos de vigilancia de ballenas.
 Este script esta pensado para ejecutarse despues de cargar:
   1) vigilar_ballenas_extendido_ddl.sql
   2) vigilar_ballenas_extendido_dml.sql
*/

/* =========================================================
   EJERCICIO 1
   Funcion ballenas_con_equipo_y_playa(nombre_ballena text)

   Justificacion:
   La informacion de la ballena esta en ballena.
   La relacion entre ballenas y equipos esta en ballena_avistada_equipo.
   La informacion del equipo esta en salvamento.
   La playa donde se ubica el equipo se obtiene con salvamento.playa_sede.
   ========================================================= */

CREATE OR REPLACE FUNCTION ballenas_con_equipo_y_playa(nombre_ballena text)
RETURNS TABLE (
    nombre_ballena_resultado varchar,
    especie varchar,
    nombre_equipo varchar,
    playa varchar,
    semana_anio bigint,
    anio bigint,
    crecimiento varchar,
    estado_salud varchar
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT b.nombre,
           b.especie,
           s.nombre,
           s.playa_sede,
           bae.semana_anio,
           bae.anio,
           bae.crecimiento,
           bae.estado_salud
    FROM ballena b
         INNER JOIN ballena_avistada_equipo bae
             ON b.num_registro = bae.registro_ballena
         INNER JOIN salvamento s
             ON bae.id_equipo = s.id_equipo
    WHERE b.nombre = nombre_ballena;

    IF NOT FOUND THEN
        RAISE NOTICE 'No hay avistamientos para la ballena %', nombre_ballena;
    END IF;
END;
$$;

-- Prueba con resultados.
SELECT * FROM ballenas_con_equipo_y_playa('Azulina');

-- Prueba sin resultados.
SELECT * FROM ballenas_con_equipo_y_playa('NoExiste');


/* =========================================================
   EJERCICIO 2
   Funcion listar_avistamientos_playa(playa text)

   Justificacion:
   Se buscan los avistamientos realizados por equipos cuya playa_sede coincide
   con la playa pasada como parametro. Se usa un bucle FOR ... IN SELECT,
   que es un bucle especifico de PL/pgSQL y no necesita declarar cursores.
   ========================================================= */

CREATE OR REPLACE FUNCTION listar_avistamientos_playa(playa text)
RETURNS void
LANGUAGE plpgsql
AS $$
DECLARE
    fila record;
    hay_datos boolean := false;
BEGIN
    FOR fila IN
        SELECT b.nombre AS nombre_ballena,
               b.especie AS especie_ballena,
               s.nombre AS nombre_equipo,
               s.playa_sede AS playa_equipo,
               bae.semana_anio,
               bae.anio,
               bae.crecimiento,
               bae.estado_salud
        FROM ballena b
             INNER JOIN ballena_avistada_equipo bae
                 ON b.num_registro = bae.registro_ballena
             INNER JOIN salvamento s
                 ON bae.id_equipo = s.id_equipo
        WHERE s.playa_sede = playa
        ORDER BY bae.anio, bae.semana_anio, b.nombre
    LOOP
        hay_datos := true;

        RAISE NOTICE 'Ballena: %, especie: %, equipo: %, playa: %, semana: %, anio: %, crecimiento: %, salud: %',
            fila.nombre_ballena,
            fila.especie_ballena,
            fila.nombre_equipo,
            fila.playa_equipo,
            fila.semana_anio,
            fila.anio,
            fila.crecimiento,
            fila.estado_salud;
    END LOOP;

    IF NOT hay_datos THEN
        RAISE NOTICE 'No hay avistamientos para la playa %', playa;
    END IF;
END;
$$;

-- Prueba con resultados.
SELECT listar_avistamientos_playa('San Lorenzo');

-- Prueba sin resultados.
SELECT listar_avistamientos_playa('Playa inexistente');


/* =========================================================
   EJERCICIO 3
   Funcion mostrar_ballenas_longevas()

   Justificacion:
   Una ballena longeva es la que pertenece a una especie cuya edad_media es
   igual a la edad_media maxima de todas las especies. En los datos cargados,
   la edad_media maxima es 80, correspondiente a Balaenoptera musculus.
   El enunciado pide recorrer esas ballenas con cursor, por eso se declara,
   se abre, se recorre con FETCH y se cierra.
   ========================================================= */

CREATE OR REPLACE FUNCTION mostrar_ballenas_longevas()
RETURNS void
LANGUAGE plpgsql
AS $$
DECLARE
    fila record;
    cur_longevas CURSOR FOR
        SELECT b.num_registro,
               b.nombre AS nombre_ballena,
               b.especie,
               e.nombre_comun,
               e.edad_media
        FROM ballena b
             INNER JOIN especie e
                 ON b.especie = e.nombre_cientifico
        WHERE e.edad_media = (SELECT MAX(edad_media) FROM especie)
        ORDER BY b.num_registro;
BEGIN
    OPEN cur_longevas;

    LOOP
        FETCH cur_longevas INTO fila;
        EXIT WHEN NOT FOUND;

        RAISE NOTICE 'Ballena longeva: registro %, nombre %, especie %, nombre comun %, edad media %',
            fila.num_registro,
            fila.nombre_ballena,
            fila.especie,
            fila.nombre_comun,
            fila.edad_media;
    END LOOP;

    CLOSE cur_longevas;
END;
$$;

-- Prueba de la funcion.
SELECT mostrar_ballenas_longevas();


/* =========================================================
   EJERCICIO 4.a
   Tabla de log de operaciones sobre avistamientos.

   Justificacion:
   La tabla guarda el momento de la operacion, el tipo de operacion y todos
   los atributos de la fila afectada de ballena_avistada_equipo.
   ========================================================= */

DROP TABLE IF EXISTS log_operaciones_avistamientos;

CREATE TABLE log_operaciones_avistamientos (
    momento timestamp NOT NULL,
    operacion char(1) NOT NULL CHECK (operacion IN ('I', 'U', 'D')),
    registro_ballena bigint,
    id_equipo bigint,
    semana_anio bigint,
    anio bigint,
    crecimiento varchar(20),
    estado_salud varchar(20)
);


/* =========================================================
   EJERCICIO 4.b
   Funcion disparadora.

   Justificacion:
   TG_OP indica que operacion ha activado el trigger.
   En INSERT y UPDATE se usa NEW porque representa la fila insertada o la
   nueva version de la fila actualizada.
   En DELETE se usa OLD porque despues de borrar ya no existe NEW.
   ========================================================= */

CREATE OR REPLACE FUNCTION registrar_operacion_avistamiento()
RETURNS trigger
LANGUAGE plpgsql
AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO log_operaciones_avistamientos
        VALUES (CURRENT_TIMESTAMP, 'I', NEW.registro_ballena, NEW.id_equipo,
                NEW.semana_anio, NEW.anio, NEW.crecimiento, NEW.estado_salud);
        RETURN NEW;

    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO log_operaciones_avistamientos
        VALUES (CURRENT_TIMESTAMP, 'U', NEW.registro_ballena, NEW.id_equipo,
                NEW.semana_anio, NEW.anio, NEW.crecimiento, NEW.estado_salud);
        RETURN NEW;

    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO log_operaciones_avistamientos
        VALUES (CURRENT_TIMESTAMP, 'D', OLD.registro_ballena, OLD.id_equipo,
                OLD.semana_anio, OLD.anio, OLD.crecimiento, OLD.estado_salud);
        RETURN OLD;
    END IF;

    RETURN NULL;
END;
$$;


/* =========================================================
   EJERCICIO 4.c
   Vinculacion de la funcion a INSERT, UPDATE y DELETE.

   Justificacion:
   Se crean tres triggers AFTER y FOR EACH ROW, uno para cada operacion.
   ========================================================= */

DROP TRIGGER IF EXISTS trg_log_insert_avistamiento ON ballena_avistada_equipo;
DROP TRIGGER IF EXISTS trg_log_update_avistamiento ON ballena_avistada_equipo;
DROP TRIGGER IF EXISTS trg_log_delete_avistamiento ON ballena_avistada_equipo;

CREATE TRIGGER trg_log_insert_avistamiento
AFTER INSERT ON ballena_avistada_equipo
FOR EACH ROW
EXECUTE FUNCTION registrar_operacion_avistamiento();

CREATE TRIGGER trg_log_update_avistamiento
AFTER UPDATE ON ballena_avistada_equipo
FOR EACH ROW
EXECUTE FUNCTION registrar_operacion_avistamiento();

CREATE TRIGGER trg_log_delete_avistamiento
AFTER DELETE ON ballena_avistada_equipo
FOR EACH ROW
EXECUTE FUNCTION registrar_operacion_avistamiento();


/* =========================================================
   EJERCICIO 4.d
   Pruebas del disparador.

   Justificacion:
   Se hacen dos inserciones, dos actualizaciones y dos borrados sobre filas
   que respetan las claves ajenas y la clave primaria de ballena_avistada_equipo.
   Al final se consulta la tabla de log para comprobar que se han registrado
   las seis operaciones.
   ========================================================= */

-- Dos inserciones.
INSERT INTO ballena_avistada_equipo
VALUES (1001, 1, 20, 2024, 'normal', 'normal');

INSERT INTO ballena_avistada_equipo
VALUES (1002, 2, 21, 2024, 'alto', 'normal');

-- Dos actualizaciones.
UPDATE ballena_avistada_equipo
SET estado_salud = 'malo'
WHERE registro_ballena = 1001
  AND id_equipo = 1
  AND semana_anio = 20
  AND anio = 2024;

UPDATE ballena_avistada_equipo
SET crecimiento = 'normal'
WHERE registro_ballena = 1002
  AND id_equipo = 2
  AND semana_anio = 21
  AND anio = 2024;

-- Dos borrados.
DELETE FROM ballena_avistada_equipo
WHERE registro_ballena = 1001
  AND id_equipo = 1
  AND semana_anio = 20
  AND anio = 2024;

DELETE FROM ballena_avistada_equipo
WHERE registro_ballena = 1002
  AND id_equipo = 2
  AND semana_anio = 21
  AND anio = 2024;

-- Consulta de comprobacion del log.
SELECT *
FROM log_operaciones_avistamientos
ORDER BY momento;
