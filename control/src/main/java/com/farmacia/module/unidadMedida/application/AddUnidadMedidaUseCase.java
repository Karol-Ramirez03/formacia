package com.farmacia.module.unidadMedida.application;

import com.farmacia.module.unidadMedida.domain.entity.UnidadMedida;
import com.farmacia.module.unidadMedida.domain.service.UnidadMedidaService;

public class AddUnidadMedidaUseCase {
    private final UnidadMedidaService unidadService;

    public AddUnidadMedidaUseCase(UnidadMedidaService unidadService) {
        this.unidadService = unidadService;
    }

    public void execute(UnidadMedida unidad){
        unidadService.createUnidadMedida(unidad);
    }
}
