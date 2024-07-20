package com.farmacia.module.barrio.application;

import java.util.List;

import com.farmacia.module.barrio.domain.entity.Barrio;
import com.farmacia.module.barrio.domain.service.BarrioService;

public class FindBarrioAllUseCase {
    private final BarrioService barrioService;

    public FindBarrioAllUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public  List<Barrio> execute(){
        return barrioService.findAllBarrio();
    }
}
