

INSERT INTO medicamentos_db.sedes (nombre, direccion) VALUES 
('Farmacia Central', 'Calle Las Flores 123, Lima'),
('Sucursal Norte', 'Av. Universitaria 4500, Los Olivos'),
('Sede Hospitalaria', 'Jr. Salud 789, Miraflores'),
('Almacén Principal', 'Zona Industrial Nave 4, Callao');

INSERT INTO medicamentos_db.medicamentos (nombre, descripcion, unidad_medida) VALUES 
('Amoxicilina 500mg', 'Antibiótico de amplio espectro', 'tabletas'),
('Ibuprofeno 400mg', 'Analgésico y antiinflamatorio', 'tabletas'),
('Loratadina 10mg', 'Antihistamínico para alergias', 'tabletas'),
('Omeprazol 20mg', 'Protector gástrico', 'cápsulas'),
('Salbutamol Inhalador', 'Broncodilatador para asma', 'frasco'),
('Alcohol Isopropílico', 'Desinfectante al 70%', 'mililitros'),
('Vitamina C', 'Suplemento dietético efervescente', 'tabletas');

INSERT INTO medicamentos_db.inventarios (stock_actual, stock_minimo, medicamento_id, sede_id) VALUES 
(500, 100, 1, 1), -- Amoxicilina en Central
(250, 50, 2, 1),  -- Ibuprofeno en Central
(10, 20, 3, 2),   -- Loratadina en Sucursal Norte (¡Aquí el stock es bajo!)
(100, 30, 4, 3),  -- Omeprazol en Sede Hospitalaria
(15, 5, 5, 1),    -- Salbutamol en Central
(2000, 500, 6, 4), -- Alcohol en Almacén Principal
(80, 20, 7, 2);   -- Vitamina C en Sucursal Norte
