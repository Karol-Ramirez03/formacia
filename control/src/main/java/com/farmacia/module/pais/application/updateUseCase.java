
package com.farmacia.module.pais.application;
import com.farmacia.module.pais.domain.service.paisService;

public class updateUseCase {
    private final paisService paisService;

    public updateUseCase(paisService paisService) {
        this.paisService = paisService;
    }

    public void execute(String id) {
        paisService.updatePais(id);
    }
}

