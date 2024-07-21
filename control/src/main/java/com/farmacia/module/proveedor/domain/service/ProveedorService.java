package com.farmacia.module.proveedor.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.proveedor.domain.entity.Proveedor;

public interface ProveedorService {
    public void createProveedor(Proveedor proveedor);
    public void deleteProveedor(int id);
    public void updateProveedor(Proveedor proveedor);
    public Optional<Proveedor> findProveedorById(int id);
    public List<Proveedor> findProveedorAll();
}
