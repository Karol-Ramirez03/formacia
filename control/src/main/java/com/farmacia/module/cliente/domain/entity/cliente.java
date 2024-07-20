package com.farmacia.module.cliente.domain.entity;

import java.util.Date;

public class cliente {
    private String id;
    private String nombre;
    private int tipoDocumento;
    private String apellidos;
    private int edad;
    private Date fechaNacimiento;
    private Date fechaRegistro; 
    private int barrio;

    

    public cliente(String id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    // Constructor con todos los campos, incluyendo fechaRegistro
    public cliente(String id, String nombre, int tipoDocumento, String apellidos, int edad, Date fechaNacimiento,
            Date fechaRegistro, int barrio) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.barrio = barrio;
    }

    // Constructor sin fechaRegistro, para cuando sea autogenerado por la base de datos
    public cliente(String id, String nombre, int tipoDocumento, String apellidos, int edad, Date fechaNacimiento, int barrio) {
        this.id = id;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.barrio = barrio;
        this.fechaRegistro = null; // Se asignará automáticamente en la base de datos
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getBarrio() {
        return barrio;
    }

    public void setBarrio(int barrio) {
        this.barrio = barrio;
    }
}
