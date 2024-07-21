package com.farmacia.module.proveedor.application;

import com.farmacia.module.proveedor.domain.entity.Proveedor;
import com.farmacia.module.proveedor.domain.service.ProveedorService;

public class AddProveedorUseCase {
    private final ProveedorService preveedorService;

    public AddProveedorUseCase(ProveedorService preveedorService) {
        this.preveedorService = preveedorService;
    }
    public void execute(Proveedor proveedor){
        preveedorService.createProveedor(proveedor);
    }
    
}
