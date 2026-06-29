create table ballena (
	num_registro bigint primary key,   -- codigo de identificación
	nombre varchar(20),                -- nombre con el que se conoce la ballena
	especie varchar(100),              -- foreign key a su especie (ver sentencias de alter table posteriores)
	descripcion varchar(40),			-- descripción del especimen concreto
	genero varchar(1) check (genero in ('M','H'))
);

create table salvamento (
	id_equipo bigint primary key,  -- codigo de identificación
	nombre varchar(20),            -- nombre oficial del equipo
	num_integrantes bigint,
	playa_sede varchar(100)        -- foreign key a su especie (ver sentencias de alter table posteriores)
);

create table playa (
	nombre varchar(100) primary key,
	descripcion varchar(100) 
);

create table ballena_avistada_equipo (   -- tabla de una relación muchos a muchos entre ballena, y equipo que la avista
	registro_ballena bigint,      -- fk a ballena
	id_equipo bigint,             -- fk a equipo
	semana_anio bigint,           -- semana del año en la que se produce avistamiento (solo se hace una salida a la semana con este objetivo)
	anio bigint,                  -- año de avistamiento
	crecimiento varchar(20) check (crecimiento in ('bajo','normal','alto')),
	estado_salud  varchar(20) check (estado_salud in ('malo','normal')),
	primary key (registro_ballena,id_equipo,semana_anio,anio)   -- se necesita la semana y el año porque se guarda histórico de avistamientos
);

create table embarcacion (
	matricula varchar(20) primary key,
	nombre varchar(20),
	descripcion varchar(20),
	numero_plazas bigint,
	id_equipo_salvamento bigint
);

create table especie (
	nombre_cientifico varchar(100) primary key,
	nombre_comun varchar(100),
	tamano_adulto bigint,
	edad_media bigint
);

alter table ballena 
add constraint fk_ballena_especie foreign key (especie) references especie (nombre_cientifico) on delete cascade on update cascade;

alter table salvamento 
add constraint fk_salvamento_sede  foreign key (playa_sede) references playa (nombre) on delete cascade on update cascade;

alter table ballena_avistada_equipo 
add constraint fk_avistamiento_ballena  foreign key (registro_ballena) references ballena (num_registro) on delete cascade on update cascade,
add constraint fk_avistamiento_equipo  foreign key (id_equipo) references salvamento (id_equipo) on delete cascade on update cascade;

alter table embarcacion
add constraint fk_embarcacion_equipo foreign key (id_equipo_salvamento) references salvamento (id_equipo) on delete cascade on update cascade;



