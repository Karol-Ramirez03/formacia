package com.farmacia.module.pais.domain.entity;

public class Pais {
    private String nombre;
    private int id;

    

    public Pais(String nombre, int id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
