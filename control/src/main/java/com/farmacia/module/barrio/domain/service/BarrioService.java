
package com.farmacia.module.barrio.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.barrio.domain.entity.Barrio;



public interface BarrioService {
    public void createBarrio(Barrio Barrio);
    public void updateBarrio(Barrio Barrio);
    public void deleteBarrio(int id);
    public Optional<Barrio> findBarrioById(int id);
    public List<Barrio> findAllBarrio();
    
} 
