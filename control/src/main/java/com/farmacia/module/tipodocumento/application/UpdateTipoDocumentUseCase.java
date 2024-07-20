package com.farmacia.module.tipodocumento.application;

import com.farmacia.module.tipodocumento.domain.service.TipoDocumentoService;

public class UpdateTipoDocumentUseCase {
      private final TipoDocumentoService tdservice;

    public UpdateTipoDocumentUseCase(TipoDocumentoService tdservice) {
        this.tdservice = tdservice;
    }

    public void execute(String id) {
        tdservice.updateTipoDocumento(id);
    }
}
