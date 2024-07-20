package com.farmacia.module.barrio.application;

import com.farmacia.module.barrio.domain.entity.Barrio;
import com.farmacia.module.barrio.domain.service.BarrioService;

public class UpdateBarrioUseCase {
    private final BarrioService barrioService;

    public UpdateBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public void execute(Barrio barrio){
        barrioService.updateBarrio(barrio);
    }
}
