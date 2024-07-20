package com.farmacia.module.cliente.application;

import java.util.Optional;

import com.farmacia.module.cliente.domain.entity.cliente;
import com.farmacia.module.cliente.domain.service.clienteService;


public class findIdUseCase {
    public final clienteService clienteService;

    public findIdUseCase(clienteService clienteService) {
        this.clienteService = clienteService;
    }

    public Optional<cliente> execute(String id){
        return clienteService.findbyid(id);
    }
    
}
