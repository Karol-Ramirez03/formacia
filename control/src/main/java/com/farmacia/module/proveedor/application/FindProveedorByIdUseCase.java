package com.farmacia.module.proveedor.application;

import java.util.Optional;

import com.farmacia.module.proveedor.domain.entity.Proveedor;
import com.farmacia.module.proveedor.domain.service.ProveedorService;

public class FindProveedorByIdUseCase {
    private final ProveedorService preveedorService;

    public FindProveedorByIdUseCase(ProveedorService preveedorService) {
        this.preveedorService = preveedorService;
    }
    public Optional<Proveedor> execute(int id){
        return preveedorService.findProveedorById(id);
    }
}
