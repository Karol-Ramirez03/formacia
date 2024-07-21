package com.farmacia.module.laboratorio.application;

import com.farmacia.module.laboratorio.domain.service.LaboratorioService;

public class UpdateLaboratorioUseCase {
    private final LaboratorioService laboratorioService;

    public UpdateLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public void execute(int id){
        laboratorioService.updatelaboratorio(id);
    }
}
