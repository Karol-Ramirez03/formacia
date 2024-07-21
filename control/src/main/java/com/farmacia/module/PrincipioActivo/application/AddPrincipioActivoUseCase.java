package com.farmacia.module.PrincipioActivo.application;

import com.farmacia.module.PrincipioActivo.domain.entity.PrincipioActivo;
import com.farmacia.module.PrincipioActivo.domain.service.PrincipioActivoService;

public class AddPrincipioActivoUseCase {
    private final PrincipioActivoService principioService;

    public AddPrincipioActivoUseCase(PrincipioActivoService principioService) {
        this.principioService = principioService;
    }
    public void execute(PrincipioActivo principioActivo){
        principioService.createPrincipioActivo(principioActivo);
    }
}
