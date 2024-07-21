package com.farmacia.module.producto.application;

import java.util.Optional;


import com.farmacia.module.producto.domain.entity.Producto;
import com.farmacia.module.producto.domain.service.ProductoService;

public class FindProductoByIdUseCase {
    private final ProductoService productoService;

    public FindProductoByIdUseCase(ProductoService productoService) {
        this.productoService = productoService;
    }

    public Optional<Producto> execute(String codigo){
        return productoService.findbyid(codigo);
    }
}
