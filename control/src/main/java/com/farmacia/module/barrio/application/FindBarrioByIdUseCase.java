package com.farmacia.module.barrio.application;

import java.util.Optional;

import com.farmacia.module.barrio.domain.entity.Barrio;
import com.farmacia.module.barrio.domain.service.BarrioService;


public class FindBarrioByIdUseCase {
    private final BarrioService barrioService;

    public FindBarrioByIdUseCase(BarrioService barrioService) {
        this.barrioService = barrioService;
    }

    public Optional<Barrio> execute(int id){
        return barrioService.findBarrioById(id);
    }
}
