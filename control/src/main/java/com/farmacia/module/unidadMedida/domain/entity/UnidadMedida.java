package com.farmacia.module.unidadMedida.domain.entity;

public class UnidadMedida {
    private int id;
    private String descripcion;

    public UnidadMedida(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public UnidadMedida(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

}
