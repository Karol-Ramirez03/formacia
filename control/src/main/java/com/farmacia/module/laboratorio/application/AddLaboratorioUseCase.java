package com.farmacia.module.laboratorio.application;

import com.farmacia.module.laboratorio.domain.entity.Laboratorio;
import com.farmacia.module.laboratorio.domain.service.LaboratorioService;

public class AddLaboratorioUseCase {
    private final LaboratorioService laboratorioService;

    public AddLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void add(Laboratorio laboratorio){
        laboratorioService.createLaboratorio(laboratorio);
    }
}
