package com.farmacia.module.ciudad.application;

import com.farmacia.module.ciudad.domain.entity.Ciudad;
import com.farmacia.module.ciudad.domain.service.CiudadService;

public class AddCiudadUseCase {
    private final CiudadService ciudadService;

    public AddCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad){
        ciudadService.createCiudad(ciudad);
    }
}
