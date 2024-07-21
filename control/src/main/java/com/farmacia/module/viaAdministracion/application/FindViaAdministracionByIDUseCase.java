package com.farmacia.module.viaAdministracion.application;

import java.util.Optional;

import com.farmacia.module.viaAdministracion.domain.entity.ViaAdministracion;
import com.farmacia.module.viaAdministracion.domain.service.ViaAdministracionService;

public class FindViaAdministracionByIDUseCase {
    private final ViaAdministracionService viaAdminService;

    public FindViaAdministracionByIDUseCase(ViaAdministracionService viaAdminService) {
        this.viaAdminService = viaAdminService;
    }

    public Optional<ViaAdministracion> execute(int id){
        return viaAdminService.findViaAdministracionById(id);
    }
}
