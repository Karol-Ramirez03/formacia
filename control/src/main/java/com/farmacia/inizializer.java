package com.farmacia;

import com.farmacia.module.cliente.adapter.in.clienteConsoleAdapter;
import com.farmacia.module.cliente.application.addUseCase;
import com.farmacia.module.cliente.application.clienteDeleteUseCase;
import com.farmacia.module.cliente.application.findAllUseCase;
import com.farmacia.module.cliente.application.findIdUseCase;
import com.farmacia.module.cliente.application.updateClienteUseCase;
import com.farmacia.module.cliente.infrastructure.clienteRepository;

public class inizializer {

    public  void clienteStart(){
        clienteRepository clienteRepository = new clienteRepository();
        addUseCase addUseCase = new addUseCase(clienteRepository);
        findAllUseCase findAll = new findAllUseCase(clienteRepository);
        findIdUseCase findId = new findIdUseCase(clienteRepository);
        clienteDeleteUseCase delete = new clienteDeleteUseCase(clienteRepository);
        updateClienteUseCase update = new updateClienteUseCase(clienteRepository);
        clienteConsoleAdapter console = new clienteConsoleAdapter(addUseCase, findAll, findId, delete,update);

        console.start();
    }
    
}
