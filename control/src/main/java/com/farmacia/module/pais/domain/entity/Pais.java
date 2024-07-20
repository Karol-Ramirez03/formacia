package com.farmacia.module.pais.domain.entity;

public class Pais {
    private String nombre;
    private String id;

    

    public Pais(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
