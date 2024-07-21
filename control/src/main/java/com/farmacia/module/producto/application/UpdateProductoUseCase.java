package com.farmacia.module.producto.application;

import com.farmacia.module.producto.domain.entity.Producto;
import com.farmacia.module.producto.domain.service.ProductoService;

public class UpdateProductoUseCase {
    private final ProductoService productoService;

    public UpdateProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void execute(Producto producto){
        productoService.update(producto);
    }
}
