package com.farmacia.module.unidadMedida.application;

import com.farmacia.module.unidadMedida.domain.service.UnidadMedidaService;

public class UpdateUnidadMedidaUseCase {
    private final UnidadMedidaService unidadService;

    public UpdateUnidadMedidaUseCase(UnidadMedidaService unidadService) {
        this.unidadService = unidadService;
    }

    public void execute(int id){
        unidadService.updateUnidadMedida(id);
    }
}
