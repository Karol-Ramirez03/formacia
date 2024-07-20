-- Insertar países
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
