package com.farmacia.module.producto.domain.entity;

import java.sql.Date;

public class Producto {
   private String codigoProducto;
    private String nombreProducto;
    private String registroInvima;
    private int viaAdministracion;
    private int principioActivo;
    private int unidadMedida;
    private int laboratorio;
    private int proveedor;
    private String presentacion;
    private Date fechaCaducidad;
    private Double valorCompra;
    private Double margenGanancia;
    private Integer stock;
    private Integer stockMin;
    private Integer stockMax;
    private Double valorVenta;


    public Producto(String codigoProducto, String nombreProducto, String registroInvima, int viaAdministracion, int principioActivo, int unidadMedida, int laboratorio, int proveedor, String presentacion, Date fechaCaducidad, Double valorCompra, Double margenGanancia, Integer stock, Integer stockMin, Integer stockMax, Double valorVenta) {
        
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.registroInvima = registroInvima;
        this.viaAdministracion = viaAdministracion;
        this.principioActivo = principioActivo;
        this.unidadMedida = unidadMedida;
        this.laboratorio = laboratorio;
        this.proveedor = proveedor;
        this.presentacion = presentacion;
        this.fechaCaducidad = fechaCaducidad;
        this.valorCompra = valorCompra;
        this.margenGanancia = margenGanancia;
        this.stock = stock;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.valorVenta = valorVenta;
    }
    
    public String getCodigoProducto() {
        return codigoProducto;
    }
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getRegistroInvima() {
        return registroInvima;
    }
    public void setRegistroInvima(String registroInvima) {
        this.registroInvima = registroInvima;
    }
    public int getViaAdministracion() {
        return viaAdministracion;
    }
    public void setViaAdministracion(int viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }
    public int getPrincipioActivo() {
        return principioActivo;
    }
    public void setPrincipioActivo(int principioActivo) {
        this.principioActivo = principioActivo;
    }
    public int getUnidadMedida() {
        return unidadMedida;
    }
    public void setUnidadMedida(int unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    public int getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }
    public int getProveedor() {
        return proveedor;
    }
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }
    public String getPresentacion() {
        return presentacion;
    }
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    public Double getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public Double getMargenGanancia() {
        return margenGanancia;
    }
    public void setMargenGanancia(Double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Integer getStockMin() {
        return stockMin;
    }
    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
    }
    public Integer getStockMax() {
        return stockMax;
    }
    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
    }
    public Double getValorVenta() {
        return valorVenta;
    }
    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    
}
