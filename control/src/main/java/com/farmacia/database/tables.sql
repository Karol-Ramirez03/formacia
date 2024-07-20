CREATE DATABASE farmacia;
USE farmacia;

CREATE TABLE pais(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    CONSTRAINT PkPais PRIMARY KEY (id)
);

CREATE TABLE tipoDocumento(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(20),
    CONSTRAINT PkTipoDocumento PRIMARY KEY (id)
);

CREATE TABLE ciudad(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    pais int,
    CONSTRAINT Pkciudad PRIMARY KEY (id),
    CONSTRAINT FkCiudadPais FOREIGN KEY (pais) REFERENCES pais(id)
);

CREATE TABLE barrio(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(60),
    ciudad INT,
    CONSTRAINT PkBarrio PRIMARY KEY (id),
    CONSTRAINT FkBarrioCiudad FOREIGN KEY (ciudad) REFERENCES ciudad(id)
);

CREATE TABLE cliente(
    id VARCHAR(20),
    tipoDocumento INT,
    nombres VARCHAR(80),
    apellidos VARCHAR(80),
    edad INT,
    fechaNacimiento DATE,
    fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    barrio INT,
    CONSTRAINT PkCliente PRIMARY KEY (id),
    CONSTRAINT FkClienteTipoDocumento FOREIGN KEY (tipoDocumento) REFERENCES tipoDocumento (id),
    CONSTRAINT fkbarrio FOREIGN KEY (barrio) REFERENCES barrio (id)
);







CREATE TABLE unidad_medida (
    id INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50)
);

CREATE TABLE laboratorio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE proveedor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    contacto VARCHAR(100)
);

CREATE TABLE producto (
    codigo_producto VARCHAR(50) PRIMARY KEY,
    nombre_producto VARCHAR(100),
    registro_invima VARCHAR(50),
    via_administracion VARCHAR(100),
    principio_activo VARCHAR(100),
    unidad_medida_id INT,
    laboratorio_id INT,
    proveedor_id INT,
    presentacion VARCHAR(100),
    fecha_caducidad DATE,
    valor_compra DECIMAL(10,2),
    margen_ganancia DECIMAL(5,2),
    stock INT,
    stock_min INT,
    stock_max INT,
    valor_venta DECIMAL(10,2) GENERATED ALWAYS AS (valor_compra * (1 + (margen_ganancia / 100))) STORED,
    FOREIGN KEY (unidad_medida_id) REFERENCES unidad_medida(id),
    FOREIGN KEY (laboratorio_id) REFERENCES laboratorio(id),
    FOREIGN KEY (proveedor_id) REFERENCES proveedor(id)
);