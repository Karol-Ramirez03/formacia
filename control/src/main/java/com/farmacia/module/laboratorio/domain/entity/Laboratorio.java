package com.farmacia.module.laboratorio.domain.entity;

public class Laboratorio {
    private int id;
    private String nombre;
    
    public Laboratorio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Laboratorio(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
