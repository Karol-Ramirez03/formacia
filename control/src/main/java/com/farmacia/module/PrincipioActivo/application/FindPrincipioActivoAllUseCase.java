package com.farmacia.module.PrincipioActivo.application;

import java.util.List;

import com.farmacia.module.PrincipioActivo.domain.entity.PrincipioActivo;
import com.farmacia.module.PrincipioActivo.domain.service.PrincipioActivoService;

public class FindPrincipioActivoAllUseCase {
    private final PrincipioActivoService principioService;

    public FindPrincipioActivoAllUseCase(PrincipioActivoService principioService) {
        this.principioService = principioService;
    }
    public List<PrincipioActivo> execute(){
        return principioService.findAllPrincipioActivo();
    }
}
