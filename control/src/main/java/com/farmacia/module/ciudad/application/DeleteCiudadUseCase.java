package com.farmacia.module.ciudad.application;

import com.farmacia.module.ciudad.domain.service.CiudadService;

public class DeleteCiudadUseCase {
    private final CiudadService ciudadService;

        public DeleteCiudadUseCase(CiudadService ciudadService) {
            this.ciudadService = ciudadService;
        }

        public void execute(int id){
            ciudadService.deleteCiudad(id);
        }
}
