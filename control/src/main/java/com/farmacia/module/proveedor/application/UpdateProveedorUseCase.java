package com.farmacia.module.proveedor.application;

import com.farmacia.module.proveedor.domain.entity.Proveedor;
import com.farmacia.module.proveedor.domain.service.ProveedorService;

public class UpdateProveedorUseCase {
    private final ProveedorService preveedorService;

    public UpdateProveedorUseCase(ProveedorService preveedorService) {
        this.preveedorService = preveedorService;
    }

    public void execute(Proveedor proveedor){
        preveedorService.updateProveedor(proveedor);
    }
}
