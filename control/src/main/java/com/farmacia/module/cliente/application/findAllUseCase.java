package com.farmacia.module.cliente.application;

import java.util.List;

import com.farmacia.module.cliente.domain.entity.cliente;
import com.farmacia.module.cliente.domain.service.clienteService;

public class findAllUseCase {
    private final clienteService clienteService;

    public findAllUseCase(clienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<cliente> findAll() {
        return clienteService.findAll();
    }  

}
