package com.farmacia.module.viaAdministracion.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.viaAdministracion.domain.entity.ViaAdministracion;

public interface ViaAdministracionService{
   public void createViaAdministracion(ViaAdministracion viaAdministracion);
    public void updateViaAdministracion(int id);
    public void deleteViaAdministracion(int id);
    public Optional<ViaAdministracion> findViaAdministracionById(int id);
    public List<ViaAdministracion> findAllViaAdministracion();
}
