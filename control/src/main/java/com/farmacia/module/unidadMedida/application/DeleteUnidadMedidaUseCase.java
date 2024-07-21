package com.farmacia.module.unidadMedida.application;

import com.farmacia.module.unidadMedida.domain.service.UnidadMedidaService;

public class DeleteUnidadMedidaUseCase {
    private final UnidadMedidaService unidadService;

    public DeleteUnidadMedidaUseCase(UnidadMedidaService unidadService) {
        this.unidadService = unidadService;
    }

    public void execute(int id){
        unidadService.deleteUnidadMedida(id);
    }
}
