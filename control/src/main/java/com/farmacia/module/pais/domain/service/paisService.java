package com.farmacia.module.pais.domain.service;

import java.util.List;

import com.farmacia.module.pais.domain.entity.Pais;

public interface paisService {
    public void createPais(Pais Pais);
    public void updatePais( String id);
    public void deletePais(String id);
    public Pais findPaisById(String id);
    public List<Pais> findAllPais();
}
