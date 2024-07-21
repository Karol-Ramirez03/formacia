package com.farmacia.module.laboratorio.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.laboratorio.domain.entity.Laboratorio;

public interface LaboratorioService {
    public void createLaboratorio(Laboratorio laboratorio);
    public void deleteLaboratorio(int id);
    public void updatelaboratorio(int id);
    public Optional<Laboratorio> findLaboratorioById(int id);
    public List<Laboratorio> findLaboratorioAll();

}
