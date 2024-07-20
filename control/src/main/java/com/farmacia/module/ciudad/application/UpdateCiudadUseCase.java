package com.farmacia.module.ciudad.application;

import com.farmacia.module.ciudad.domain.entity.Ciudad;
import com.farmacia.module.ciudad.domain.service.CiudadService;

public class UpdateCiudadUseCase {
    private final CiudadService ciudadService;

    public UpdateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad){
        ciudadService.updateCiudad(ciudad);
    }
}
