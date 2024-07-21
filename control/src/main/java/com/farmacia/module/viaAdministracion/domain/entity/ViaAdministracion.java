package com.farmacia.module.viaAdministracion.domain.entity;

public class ViaAdministracion {
    private int id;
    private String descripcion;

    
    public ViaAdministracion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public ViaAdministracion(String descripcion) {
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
