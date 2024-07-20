package com.farmacia.module.barrio.application;

import com.farmacia.module.barrio.domain.service.BarrioService;

public class DeleteBarrioUseCase {
    private final BarrioService barrioService;

    public DeleteBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public void execute(int id){
        barrioService.deleteBarrio(id);
    }
}
