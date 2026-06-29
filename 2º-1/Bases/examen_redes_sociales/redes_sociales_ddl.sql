

CREATE TABLE persona (
    dni VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    apellido VARCHAR(40) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    ciudad VARCHAR(40) NOT NULL
);

CREATE TABLE red_social (
    nombre VARCHAR(40) PRIMARY KEY,
    empresa VARCHAR(60) NOT NULL,
    fecha_lanzamiento DATE NOT NULL
);

CREATE TABLE perfil (
    dni_persona VARCHAR(9) NOT NULL REFERENCES persona(dni),
    nombre_red VARCHAR(40) NOT NULL REFERENCES red_social(nombre),
    usuario VARCHAR(40) NOT NULL,
    fecha_alta DATE NOT NULL,
    tipo_cuenta VARCHAR(20) NOT NULL CHECK (tipo_cuenta IN ('personal', 'profesional', 'creador')),
    CONSTRAINT pk_perfil PRIMARY KEY (dni_persona, nombre_red)
);

CREATE TABLE relacion (
    dni_origen VARCHAR(9) NOT NULL REFERENCES persona(dni),
    dni_destino VARCHAR(9) NOT NULL REFERENCES persona(dni),
    tipo_relacion VARCHAR(20) NOT NULL CHECK (tipo_relacion IN ('amistad', 'familiar', 'entrenamiento', 'profesional')),
    detalle VARCHAR(80),
    CONSTRAINT pk_relacion PRIMARY KEY (dni_origen, dni_destino, tipo_relacion),
    CONSTRAINT ck_relacion_distintos CHECK (dni_origen <> dni_destino)
);
