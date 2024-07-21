
INSERT INTO pais (nombre) VALUES 
('Colombia'), 
('Argentina');

INSERT INTO tipoDocumento (nombre) VALUES 
('CC'), 
('NIT');

INSERT INTO ciudad (nombre, pais) VALUES 
('Bogotá', 1), 
('Buenos Aires', 2);

INSERT INTO barrio (nombre, ciudad) VALUES 
('Chapinero', 1), 
('Palermo', 2);

INSERT INTO cliente (id, tipoDocumento, nombres, apellidos, edad, fechaNacimiento, barrio) VALUES 
('123456789', 1, 'Juan', 'Perez', 30, '1993-01-01', 1),
('987654321', 2, 'Maria', 'Gomez', 25, '1998-02-02', 2);

INSERT INTO unidad_medida (descripcion) VALUES 
('Unidad'), 
('Gramos');

INSERT INTO laboratorio (nombre) VALUES 
('Laboratorio Roche'), 
('Bayer');

INSERT INTO proveedor (nombre, contacto) VALUES 
('Proveedor A', 'contactoA@example.com'), 
('Proveedor B', 'contactoB@example.com');

INSERT INTO via_administracion (descripcion) VALUES 
('Oral'), 
('Intravenosa');

INSERT INTO principio_activo (nombre) VALUES 
('Paracetamol'), 
('Ibuprofeno');

INSERT INTO producto (codigo_producto, nombre_producto, registro_invima, via_administracion_id, principio_activo_id, unidad_medida_id, laboratorio_id, proveedor_id, presentacion, fecha_caducidad, valor_compra, margen_ganancia, stock, stock_min, stock_max) VALUES 
('P001', 'Paracetamol 500mg', 'INV001', 1, 1, 1, 1, 1, 'Caja', '2025-01-01', 10.00, 20.00, 100, 10, 200),
('P002', 'Ibuprofeno 200mg', 'INV002', 2, 2, 2, 2, 2, 'Botella', '2024-12-01', 15.00, 25.00, 200, 20, 300);