package com.farmacia.module.pais.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.pais.domain.entity.Pais;

public interface paisService {
    public void createPais(Pais Pais);
    public void updatePais(int id);
    public void deletePais(int id);
    public Optional<Pais> findPaisById(int id);
    public List<Pais> findAllPais();
}
