package com.farmacia.module.PrincipioActivo.application;

import com.farmacia.module.PrincipioActivo.domain.service.PrincipioActivoService;

public class DeletePrricipioActivoUseCase {
    private final PrincipioActivoService principioService;

    public DeletePrricipioActivoUseCase(PrincipioActivoService principioService) {
        this.principioService = principioService;
    }
    public void execute(int id){
        principioService.deletePrincipioActivo(id);;
    }
}
