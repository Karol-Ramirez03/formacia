

INSERT INTO pais (nombre) VALUES ('Argentina');
INSERT INTO pais (nombre) VALUES ('Chile');

-- Insertar tipos de documento
INSERT INTO tipoDocumento (nombre) VALUES ('DNI');
INSERT INTO tipoDocumento (nombre) VALUES ('Pasaporte');

-- Insertar ciudades
INSERT INTO ciudad (nombre, pais) VALUES ('Buenos Aires', 1);
INSERT INTO ciudad (nombre, pais) VALUES ('Santiago', 2);

-- Insertar barrios
INSERT INTO barrio (nombre, ciudad) VALUES ('Palermo', 1);
INSERT INTO barrio (nombre, ciudad) VALUES ('Providencia', 2);

-- Insertar clientes
INSERT INTO cliente (id, tipoDocumento, nombres, apellidos, edad, fechaNacimiento, barrio) VALUES 
('12345678', 1, 'Juan', 'Pérez', 30, '1994-03-15', 1),
('87654321', 2, 'Ana', 'Gómez', 25, '1999-07-20', 2);



INSERT INTO unidad_medida (descripcion) VALUES ('Mililitros');
INSERT INTO unidad_medida (descripcion) VALUES ('Gramos');


INSERT INTO laboratorio (nombre) VALUES ('Laboratorio XYZ');
INSERT INTO laboratorio (nombre) VALUES ('Laboratorio ABC');


INSERT INTO proveedor (nombre, contacto) VALUES ('Proveedor 1', 'contacto1@proveedor.com');
INSERT INTO proveedor (nombre, contacto) VALUES ('Proveedor 2', 'contacto2@proveedor.com');


INSERT INTO producto (
    codigo_producto, nombre_producto, registro_invima, via_administracion, principio_activo, 
    unidad_medida_id, laboratorio_id, proveedor_id, presentacion, fecha_caducidad, 
    valor_compra, margen_ganancia, stock, stock_min, stock_max
) VALUES (
    'P001', 'Paracetamol', 'INVIMA1234', 'Oral', 'Paracetamol', 
    1, 1, 1, 'Tabletas', '2025-12-31', 
    500.00, 20.00, 100, 10, 200
);

INSERT INTO producto (
    codigo_producto, nombre_producto, registro_invima, via_administracion, principio_activo, 
    unidad_medida_id, laboratorio_id, proveedor_id, presentacion, fecha_caducidad, 
    valor_compra, margen_ganancia, stock, stock_min, stock_max
) VALUES (
    'P002', 'Ibuprofeno', 'INVIMA5678', 'Oral', 'Ibuprofeno', 
    2, 2, 2, 'Cápsulas', '2024-06-30', 
    300.00, 15.00, 200, 20, 500
);

