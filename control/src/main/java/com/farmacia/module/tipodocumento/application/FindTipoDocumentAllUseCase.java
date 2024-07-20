package com.farmacia.module.tipodocumento.application;

import java.util.List;

import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;
import com.farmacia.module.tipodocumento.domain.service.TipoDocumentoService;

public class FindTipoDocumentAllUseCase {
    private final TipoDocumentoService tdservice;

    public FindTipoDocumentAllUseCase(TipoDocumentoService tdservice) {
        this.tdservice = tdservice;
    }
    public List<TipoDocumento> findAll() {
        return tdservice.findAllTipoDocumento();
    }
    
}
