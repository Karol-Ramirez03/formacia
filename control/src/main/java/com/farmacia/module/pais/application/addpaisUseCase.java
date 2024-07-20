package com.farmacia.module.pais.application;

import com.farmacia.module.pais.domain.entity.Pais;
import com.farmacia.module.pais.domain.service.paisService;

public class addpaisUseCase {

    private final paisService  PaisService;

    public addpaisUseCase(paisService PaisService) {
        this.PaisService = PaisService;
    }

    public void execute(Pais pais){
        PaisService.createPais(pais);
    }
}
