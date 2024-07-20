package com.farmacia.module.barrio.domain.entity;

public class Barrio {

    private int id;
    private String nombre;
    private int ciudad;

    

    public Barrio(int id, String nombre, int ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    

    public Barrio(String nombre, int ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
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
    public int getCiudad() {
        return ciudad;
    }
    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }
    
    

}
