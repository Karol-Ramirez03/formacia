package com.farmacia.module.PrincipioActivo.application;

import com.farmacia.module.PrincipioActivo.domain.service.PrincipioActivoService;

public class UpdatePrincipioActivoUseCase {
    private final PrincipioActivoService principioService;

    public UpdatePrincipioActivoUseCase(PrincipioActivoService principioService) {
        this.principioService = principioService;
    }
    public void execute(int id){
        principioService.updatePrincipioActivo(id);;
    }
}
