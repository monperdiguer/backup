
INSERT INTO persona (dni, nombre, apellido, fecha_nacimiento, ciudad) VALUES
('11111111A', 'Ana',    'Garcia',   '1999-03-12', 'Oviedo'),
('22222222B', 'Luis',   'Lopez',    '1998-07-21', 'Gijon'),
('33333333C', 'Marta',  'Suarez',   '2000-11-05', 'Aviles'),
('44444444D', 'Pablo',  'Fernandez','1997-01-30', 'Oviedo'),
('55555555E', 'Lucia',  'Martinez', '2001-05-17', 'Gijon'),
('66666666F', 'Diego',  'Alvarez',  '1996-09-09', 'Leon');

INSERT INTO red_social (nombre, empresa, fecha_lanzamiento) VALUES
('Instagram', 'Meta',       '2010-10-06'),
('LinkedIn',  'Microsoft',  '2003-05-05'),
('Strava',    'Strava Inc', '2009-08-18'),
('TikTok',    'ByteDance',  '2016-09-01');

INSERT INTO perfil (dni_persona, nombre_red, usuario, fecha_alta, tipo_cuenta) VALUES
('11111111A', 'Instagram', 'ana.garcia',      '2020-01-10', 'personal'),
('22222222B', 'Instagram', 'luis.lopez',      '2020-02-12', 'personal'),
('33333333C', 'Instagram', 'marta.suarez',    '2021-03-08', 'creador'),
('44444444D', 'Instagram', 'pablo.fdez',      '2022-04-02', 'personal'),

('11111111A', 'LinkedIn',  'ana-garcia',      '2020-05-15', 'profesional'),
('22222222B', 'LinkedIn',  'luis-lopez',      '2019-09-20', 'profesional'),
('44444444D', 'LinkedIn',  'pablo-fernandez', '2021-01-11', 'profesional'),
('66666666F', 'LinkedIn',  'diego-alvarez',   '2021-06-30', 'profesional'),

('11111111A', 'Strava',    'ana-runs',        '2022-02-01', 'personal'),
('22222222B', 'Strava',    'luis-bike',       '2022-03-01', 'personal'),
('55555555E', 'Strava',    'lucia-trail',     '2023-01-25', 'personal'),

('33333333C', 'TikTok',    'marta.codes',     '2022-08-18', 'creador'),
('55555555E', 'TikTok',    'lucia.moves',     '2023-04-05', 'creador');

INSERT INTO relacion (dni_origen, dni_destino, tipo_relacion, detalle) VALUES
('11111111A', '22222222B', 'amistad',       'universidad'),
('11111111A', '33333333C', 'familiar',      'prima'),
('11111111A', '55555555E', 'entrenamiento', 'running'),
('22222222B', '44444444D', 'profesional',   'proyecto web'),
('33333333C', '55555555E', 'amistad',       'grupo de musica'),
('44444444D', '66666666F', 'entrenamiento', 'ciclismo'),
('55555555E', '66666666F', 'familiar',      'hermano');
