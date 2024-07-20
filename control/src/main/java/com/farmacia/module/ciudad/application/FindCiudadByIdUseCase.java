package com.farmacia.module.ciudad.application;

import java.util.Optional;

import com.farmacia.module.ciudad.domain.entity.Ciudad;
import com.farmacia.module.ciudad.domain.service.CiudadService;

public class FindCiudadByIdUseCase {
private final CiudadService ciudadService;

    public FindCiudadByIdUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public Optional<Ciudad> execute(int id){
        return ciudadService.findCiudadById(id);
    }
}
