package com.farmacia.module.barrio.application;

import com.farmacia.module.barrio.domain.entity.Barrio;
import com.farmacia.module.barrio.domain.service.BarrioService;

public class AddBarrioUseCase {
    private final BarrioService barrioService;

    public AddBarrioUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public void execute(Barrio barrio){
        barrioService.createBarrio(barrio);
    }
}
