package com.farmacia.module.cliente.application;

import com.farmacia.module.cliente.domain.service.clienteService;

public class clienteDeleteUseCase {
    private final clienteService clienteService;

    public clienteDeleteUseCase(clienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(String id){
        clienteService.delete(id);
    }
}
