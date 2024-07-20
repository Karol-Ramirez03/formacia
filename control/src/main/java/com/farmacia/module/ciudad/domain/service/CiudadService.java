package com.farmacia.module.ciudad.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.ciudad.domain.entity.Ciudad;

public interface CiudadService {
    public void createCiudad(Ciudad ciudad);
    public void updateCiudad(Ciudad ciudad);
    public void deleteCiudad(int id);
    public Optional<Ciudad> findCiudadById(int id);
    public List<Ciudad> findAllCiudad();
}
