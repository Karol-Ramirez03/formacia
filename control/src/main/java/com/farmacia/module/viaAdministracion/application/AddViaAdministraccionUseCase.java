package com.farmacia.module.viaAdministracion.application;

import com.farmacia.module.viaAdministracion.domain.entity.ViaAdministracion;
import com.farmacia.module.viaAdministracion.domain.service.ViaAdministracionService;

public class AddViaAdministraccionUseCase {
    private final ViaAdministracionService viaAdminService;

    public AddViaAdministraccionUseCase(ViaAdministracionService viaAdminService) {
        this.viaAdminService = viaAdminService;
    }

    public void execute(ViaAdministracion ViaAdministracion){
        viaAdminService.createViaAdministracion(ViaAdministracion);
    }
    
}
