package com.farmacia.module.pais.application;


import java.util.Optional;

import com.farmacia.module.pais.domain.entity.Pais;
import com.farmacia.module.pais.domain.service.paisService;

public class findIdPaisUseCase {
    private final paisService paisService;

    public findIdPaisUseCase(paisService paisService) {
        this.paisService = paisService;
    }

    public Optional<Pais> execute(int id) {
        return paisService.findPaisById(id);
    }
}

