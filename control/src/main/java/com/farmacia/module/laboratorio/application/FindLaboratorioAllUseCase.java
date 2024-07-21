package com.farmacia.module.laboratorio.application;

import java.util.List;

import com.farmacia.module.laboratorio.domain.entity.Laboratorio;
import com.farmacia.module.laboratorio.domain.service.LaboratorioService;

public class FindLaboratorioAllUseCase {
    private final LaboratorioService laboratorioService;

    public FindLaboratorioAllUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }
    
    public List<Laboratorio> execute(){
        return laboratorioService.findLaboratorioAll();
    }
}
