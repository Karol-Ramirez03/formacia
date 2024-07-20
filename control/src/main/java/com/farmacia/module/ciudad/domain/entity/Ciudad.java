package com.farmacia.module.ciudad.domain.entity;

public class Ciudad {
    
    private int id;
    private String nombre;
    private int id_pais;
    private String nombreCiudad;

    public Ciudad(int id, String nombre, int id_pais) {
        this.id = id;
        this.nombre = nombre;
        this.id_pais = id_pais;
    }
    

    public Ciudad( String nombre, int id_pais) {
        this.nombre = nombre;
        this.id_pais = id_pais;
    }


    public Ciudad(int id, String nombre, int id_pais, String nombreCiudad) {
        this.id = id;
        this.nombre = nombre;
        this.id_pais = id_pais;
        this.nombreCiudad = nombreCiudad;
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

    public int getid_pais() {
        return id_pais;
    }

    public void setid_pais(int id_pais) {
        this.id_pais = id_pais;
    }


    public String getNombreCiudad() {
        return nombreCiudad;
    }


    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }




}
