package com.farmacia.module.viaAdministracion.application;



import com.farmacia.module.viaAdministracion.domain.service.ViaAdministracionService;

public class UpdateViaAdministracionUseCase {
    private final ViaAdministracionService viaAdminService;

    public UpdateViaAdministracionUseCase(ViaAdministracionService viaAdminService) {
        this.viaAdminService = viaAdminService;
    }

    public void execute(int id){
        viaAdminService.updateViaAdministracion(id);;
    }
}
