package com.farmacia.module.viaAdministracion.application;

import com.farmacia.module.viaAdministracion.domain.service.ViaAdministracionService;

public class DeleteViaAdministracionUseCase {
    private final ViaAdministracionService viaAdminService;

    public DeleteViaAdministracionUseCase(ViaAdministracionService viaAdminService) {
        this.viaAdminService = viaAdminService;
    }

    public void execute(int id){
        viaAdminService.deleteViaAdministracion(id);
    }
}
