package com.farmacia.module.proveedor.application;

import java.util.List;

import com.farmacia.module.proveedor.domain.entity.Proveedor;
import com.farmacia.module.proveedor.domain.service.ProveedorService;

public class FindProveedorAllUseCase {
    private final ProveedorService preveedorService;

    public FindProveedorAllUseCase(ProveedorService preveedorService) {
        this.preveedorService = preveedorService;
    }

    public List<Proveedor> execute(){
        return preveedorService.findProveedorAll();
    }
}
