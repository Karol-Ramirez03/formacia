package com.farmacia.module.laboratorio.application;

import com.farmacia.module.laboratorio.domain.service.LaboratorioService;

public class DeleteLaboratorioUseCase {
    private final LaboratorioService laboratorioService;

    public DeleteLaboratorioUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }
    public void execut(int id){
        laboratorioService.deleteLaboratorio(id);
    }
}
