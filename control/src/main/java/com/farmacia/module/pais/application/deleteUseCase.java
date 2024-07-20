package com.farmacia.module.pais.application;
import com.farmacia.module.pais.domain.service.paisService;

public class deleteUseCase {
    private final paisService paisService;

    public deleteUseCase(paisService paisService) {
        this.paisService = paisService;
    }

    public void execute(String id) {
        paisService.deletePais(id);
    }
}
