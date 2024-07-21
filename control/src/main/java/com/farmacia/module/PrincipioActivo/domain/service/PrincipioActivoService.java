package com.farmacia.module.PrincipioActivo.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.PrincipioActivo.domain.entity.PrincipioActivo;


public interface PrincipioActivoService {
   public void createPrincipioActivo(PrincipioActivo principioActivo);
    public void updatePrincipioActivo(int id);
    public void deletePrincipioActivo(int id);
    public Optional<PrincipioActivo> findPrincipioActivoById(int id);
    public List<PrincipioActivo> findAllPrincipioActivo();
}
