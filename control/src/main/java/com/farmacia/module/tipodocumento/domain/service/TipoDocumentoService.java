package com.farmacia.module.tipodocumento.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;



public interface TipoDocumentoService {
    public void createTipoDocumento(TipoDocumento TipoDocumento);
    public void updateTipoDocumento(int id);
    public void deleteTipoDocumento(int id);
    public Optional<TipoDocumento> findTipoDocumentoById(int id);
    public List<TipoDocumento> findAllTipoDocumento();
}
