package com.farmacia.module.unidadMedida.application;

import java.util.List;

import com.farmacia.module.unidadMedida.domain.entity.UnidadMedida;
import com.farmacia.module.unidadMedida.domain.service.UnidadMedidaService;

public class FindUnidadMedidaUseCase {
    private final UnidadMedidaService unidadService;

    public FindUnidadMedidaUseCase(UnidadMedidaService unidadService) {
        this.unidadService = unidadService;
    }

    public List<UnidadMedida> execute(){
        return unidadService.findAllUnidadMedida();
    }
}
