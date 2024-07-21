package com.farmacia.module.producto.application;

import com.farmacia.module.producto.domain.service.ProductoService;

public class DeleteProductoUseCase {
    private final ProductoService productoService;

    public DeleteProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void execute(String codigo){
        productoService.delete(codigo);
    }
}
