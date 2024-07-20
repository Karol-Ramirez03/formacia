package com.farmacia.module.tipodocumento.domain.service;

import java.util.List;

import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;



public interface TipoDocumentoService {
    public void createTipoDocumento(TipoDocumento TipoDocumento);
    public void updateTipoDocumento( String id);
    public void deleteTipoDocumento(String id);
    public TipoDocumento findTipoDocumentoById(String id);
    public List<TipoDocumento> findAllTipoDocumento();
}
