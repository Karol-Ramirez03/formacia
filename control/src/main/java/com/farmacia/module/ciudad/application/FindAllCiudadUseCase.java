package com.farmacia.module.ciudad.application;

import java.util.List;

import com.farmacia.module.ciudad.domain.entity.Ciudad;
import com.farmacia.module.ciudad.domain.service.CiudadService;

public class FindAllCiudadUseCase {
    private final CiudadService ciudadService;

    public FindAllCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public  List<Ciudad> execute(){
        return ciudadService.findAllCiudad();
    }
}
