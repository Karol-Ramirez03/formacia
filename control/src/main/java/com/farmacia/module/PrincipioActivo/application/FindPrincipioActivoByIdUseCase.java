package com.farmacia.module.PrincipioActivo.application;

import java.util.Optional;

import com.farmacia.module.PrincipioActivo.domain.entity.PrincipioActivo;
import com.farmacia.module.PrincipioActivo.domain.service.PrincipioActivoService;

public class FindPrincipioActivoByIdUseCase {
    private final PrincipioActivoService principioService;

    public FindPrincipioActivoByIdUseCase(PrincipioActivoService principioService) {
        this.principioService = principioService;
    }
    public Optional<PrincipioActivo> execute(int id){
        return principioService.findPrincipioActivoById(0);
    }
}
