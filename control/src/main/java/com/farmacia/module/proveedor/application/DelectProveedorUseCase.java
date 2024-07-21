package com.farmacia.module.proveedor.application;

import com.farmacia.module.proveedor.domain.service.ProveedorService;

public class DelectProveedorUseCase {
    private final ProveedorService preveedorService;

    public DelectProveedorUseCase(ProveedorService preveedorService) {
        this.preveedorService = preveedorService;
    }

    public void execute(int id){
        preveedorService.deleteProveedor(id);
    }
}
