
-- Especies
INSERT INTO especie VALUES 
  ('Balaenoptera musculus', 'Ballena azul', 25000, 80),
  ('Physeter macrocephalus', 'Cachalote', 18000, 70);

-- Playas
INSERT INTO playa VALUES 
  ('San Lorenzo', 'Playa urbana en Gijón'),
  ('Ribadesella', 'Playa amplia con acantilados'),
  ('Playa de la Vega', 'Playa salvaje en el concejo de Ribadesella');

-- Equipos de salvamento
INSERT INTO salvamento VALUES 
  (1, 'Equipo Norte', 10, 'San Lorenzo'),
  (2, 'Equipo Este', 8, 'Ribadesella'),
  (3, 'Equipo Oeste', 12, 'Playa de la Vega');

-- Ballenas
INSERT INTO ballena VALUES 
  (1001, 'Azulina', 'Balaenoptera musculus', 'Ejemplar joven', 'H'),
  (1002, 'Gigante', 'Balaenoptera musculus', 'Ejemplar maduro', 'M'),
  (1003, 'Cabezon', 'Physeter macrocephalus', 'Gran cabeza', 'M');

-- Embarcaciones
INSERT INTO embarcacion VALUES 
  ('AST001', 'Vigilante 1', 'Lancha rápida', 6, 1),
  ('AST002', 'Vigilante 2', 'Catamarán', 10, 1),
  ('AST003', 'Observador 1', 'Semirrígida', 5, 2),
  ('AST004', 'Observador 2', 'Yate pequeño', 8, 2),
  ('AST005', 'Norteño', 'Lancha', 4, 3);

-- Avistamientos (todas las ballenas por todos los equipos)
INSERT INTO ballena_avistada_equipo VALUES 
  (1001, 1, 12, 2024, 'normal', 'normal'),
  (1002, 1, 13, 2024, 'alto', 'normal'),
  (1003, 1, 14, 2024, 'bajo', 'malo'),

  (1001, 2, 12, 2024, 'normal', 'normal'),
  (1002, 2, 13, 2024, 'normal', 'normal'),
  (1003, 2, 14, 2024, 'normal', 'normal'),

  (1001, 3, 12, 2024, 'bajo', 'normal'),
  (1003, 3, 14, 2024, 'bajo', 'normal');
