package com.farmacia.module.producto.application;

import com.farmacia.module.producto.domain.entity.Producto;
import com.farmacia.module.producto.domain.service.ProductoService;

public class AddProductoUseCase {
    private final ProductoService productoService;

    public AddProductoUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void addProducto(Producto producto){
        productoService.add(producto);
    }

}
