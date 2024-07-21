package com.farmacia.module.unidadMedida.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.unidadMedida.domain.entity.UnidadMedida;

public interface UnidadMedidaService {
    public void createUnidadMedida(UnidadMedida UnidadMedida);
    public void updateUnidadMedida(int id);
    public void deleteUnidadMedida(int id);
    public Optional<UnidadMedida> findUnidadMedidaById(int id);
    public List<UnidadMedida> findAllUnidadMedida();
}
