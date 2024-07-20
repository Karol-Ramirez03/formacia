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