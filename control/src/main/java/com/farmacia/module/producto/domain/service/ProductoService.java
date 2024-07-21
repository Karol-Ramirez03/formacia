package com.farmacia.module.producto.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.producto.domain.entity.Producto;

public interface ProductoService {
    public Optional<Producto> findbyid(String codigo);
    public List<Producto> findAll();
    public void add(Producto producto);
    public void delete(String codigo);
    public void update(Producto producto);
}
