package com.farmacia.module.tipodocumento.domain.entity;

public class TipoDocumento {
    private int id;
    private String nombre;

    public TipoDocumento(String nombre) {
        this.nombre = nombre;
    }
    public TipoDocumento(int id, String nombre) {
        this.id = id;
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
