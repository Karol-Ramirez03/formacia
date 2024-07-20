package com.farmacia.module.tipodocumento.application;

import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;
import com.farmacia.module.tipodocumento.domain.service.TipoDocumentoService;

public class AddTipoDocumentUseCase {
    private final TipoDocumentoService tdservice;

    public AddTipoDocumentUseCase(TipoDocumentoService tdservice) {
        this.tdservice = tdservice;
    }

    public void  execute(TipoDocumento documento){
        tdservice.createTipoDocumento(documento);
    }
}
