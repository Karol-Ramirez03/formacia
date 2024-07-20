package com.farmacia.module.tipodocumento.application;

import com.farmacia.module.tipodocumento.domain.service.TipoDocumentoService;

public class DeleteTipoDocumentoUseCase {

    private final TipoDocumentoService tdservice;

    

    public DeleteTipoDocumentoUseCase(TipoDocumentoService tdservice) {
        this.tdservice = tdservice;
    }

    public void execute(String id) {
        tdservice.deleteTipoDocumento(id);
    }
}
