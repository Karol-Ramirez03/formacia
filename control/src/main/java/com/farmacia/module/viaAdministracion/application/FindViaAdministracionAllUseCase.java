package com.farmacia.module.viaAdministracion.application;

import java.util.List;

import com.farmacia.module.viaAdministracion.domain.entity.ViaAdministracion;
import com.farmacia.module.viaAdministracion.domain.service.ViaAdministracionService;

public class FindViaAdministracionAllUseCase {
    private final ViaAdministracionService viaAdminService;

    public FindViaAdministracionAllUseCase(ViaAdministracionService viaAdminService) {
        this.viaAdminService = viaAdminService;
    }

    public List<ViaAdministracion> execute(){
        return viaAdminService.findAllViaAdministracion();
    }
}
