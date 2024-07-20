package com.farmacia.module.cliente.application;

import com.farmacia.module.cliente.domain.entity.cliente;
import com.farmacia.module.cliente.domain.service.clienteService;


public class addUseCase {
    private final clienteService clienteService;

    

    public addUseCase(clienteService clienteService) {
        this.clienteService = clienteService;
    }



    public void addcliente(cliente cliente){
        clienteService.add(cliente);
    }
    
}
