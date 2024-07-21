package com.farmacia.module.laboratorio.application;

import java.util.Optional;

import com.farmacia.module.laboratorio.domain.entity.Laboratorio;
import com.farmacia.module.laboratorio.domain.service.LaboratorioService;

public class FindLaboratorioByIdUseCase {
    private final LaboratorioService laboratorioService;

    public FindLaboratorioByIdUseCase(LaboratorioService laboratorioService) {
        this.laboratorioService = laboratorioService;
    }

    public Optional<Laboratorio> execute(int id){
        return laboratorioService.findLaboratorioById(id);
    }
}
