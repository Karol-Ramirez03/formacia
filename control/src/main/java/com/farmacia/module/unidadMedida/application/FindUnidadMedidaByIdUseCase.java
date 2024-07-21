package com.farmacia.module.unidadMedida.application;

import java.util.Optional;

import com.farmacia.module.unidadMedida.domain.entity.UnidadMedida;
import com.farmacia.module.unidadMedida.domain.service.UnidadMedidaService;

public class FindUnidadMedidaByIdUseCase {
    private final UnidadMedidaService unidadService;

    public FindUnidadMedidaByIdUseCase(UnidadMedidaService unidadService) {
        this.unidadService = unidadService;
    }

    public Optional<UnidadMedida> execute(int id){
        return unidadService.findUnidadMedidaById(id);
    }
}
