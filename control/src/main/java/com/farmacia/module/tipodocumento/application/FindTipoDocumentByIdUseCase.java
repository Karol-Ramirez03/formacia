package com.farmacia.module.tipodocumento.application;


import java.util.Optional;

import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;
import com.farmacia.module.tipodocumento.domain.service.TipoDocumentoService;

public class FindTipoDocumentByIdUseCase {
      private final TipoDocumentoService tdservice;

    public FindTipoDocumentByIdUseCase(TipoDocumentoService tdservice) {
        this.tdservice = tdservice;
    }

    public Optional<TipoDocumento> execute(int id) {
        return tdservice.findTipoDocumentoById(id);
    }  
}
