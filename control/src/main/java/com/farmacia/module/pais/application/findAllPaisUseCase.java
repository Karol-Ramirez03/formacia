package com.farmacia.module.pais.application;
import java.util.List;

import com.farmacia.module.pais.domain.entity.Pais;
import com.farmacia.module.pais.domain.service.paisService;

public class findAllPaisUseCase {
    private final paisService paisService;

    public findAllPaisUseCase(paisService paisService) {
        this.paisService = paisService;
    }

    public List<Pais> findAll() {
        return paisService.findAllPais();
    }
}

