package com.farmacia.module.producto.application;

import java.util.List;

import com.farmacia.module.producto.domain.entity.Producto;
import com.farmacia.module.producto.domain.service.ProductoService;

public class FindProductoAllUseCase {
    private final ProductoService productoService;

    public FindProductoAllUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public List<Producto> execute(){
        return productoService.findAll();
    }
}
