package com.farmacia.module.cliente.application;

import com.farmacia.module.cliente.domain.entity.cliente;
import com.farmacia.module.cliente.domain.service.clienteService;

public class updateClienteUseCase {
private final clienteService clienteService;

    public updateClienteUseCase(clienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(cliente cliente) {
        clienteService.update(cliente);
    }
}
