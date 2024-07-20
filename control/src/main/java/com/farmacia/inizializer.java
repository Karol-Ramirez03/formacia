package com.farmacia;

import com.farmacia.module.barrio.adapter.in.BarrioConsoleAdapter;
import com.farmacia.module.barrio.application.AddBarrioUseCase;
import com.farmacia.module.barrio.application.DeleteBarrioUseCase;
import com.farmacia.module.barrio.application.FindBarrioAllUseCase;
import com.farmacia.module.barrio.application.FindBarrioByIdUseCase;
import com.farmacia.module.barrio.application.UpdateBarrioUseCase;
import com.farmacia.module.barrio.infrastructure.BarrioRepository;
import com.farmacia.module.ciudad.adapter.in.CiudadConsoleAdapter;
import com.farmacia.module.ciudad.application.AddCiudadUseCase;
import com.farmacia.module.ciudad.application.DeleteCiudadUseCase;
import com.farmacia.module.ciudad.application.FindAllCiudadUseCase;
import com.farmacia.module.ciudad.application.FindCiudadByIdUseCase;
import com.farmacia.module.ciudad.application.UpdateCiudadUseCase;
import com.farmacia.module.ciudad.infrastructure.CiudadRepository;
import com.farmacia.module.cliente.adapter.in.clienteConsoleAdapter;
import com.farmacia.module.cliente.application.addUseCase;
import com.farmacia.module.cliente.application.clienteDeleteUseCase;
import com.farmacia.module.cliente.application.findAllUseCase;
import com.farmacia.module.cliente.application.findIdUseCase;
import com.farmacia.module.cliente.application.updateClienteUseCase;
import com.farmacia.module.cliente.infrastructure.clienteRepository;
import com.farmacia.module.pais.adapter.in.paisConsoleAdapter;
import com.farmacia.module.pais.application.addpaisUseCase;
import com.farmacia.module.pais.application.deleteUseCase;
import com.farmacia.module.pais.application.findAllPaisUseCase;
import com.farmacia.module.pais.application.findIdPaisUseCase;
import com.farmacia.module.pais.application.updateUseCase;
import com.farmacia.module.pais.infrastructure.paisRepository;
import com.farmacia.module.tipodocumento.adapter.in.TipoDocumentoConsoleAdapter;
import com.farmacia.module.tipodocumento.application.AddTipoDocumentUseCase;
import com.farmacia.module.tipodocumento.application.DeleteTipoDocumentoUseCase;
import com.farmacia.module.tipodocumento.application.FindTipoDocumentAllUseCase;
import com.farmacia.module.tipodocumento.application.FindTipoDocumentByIdUseCase;
import com.farmacia.module.tipodocumento.application.UpdateTipoDocumentUseCase;
import com.farmacia.module.tipodocumento.infrastructure.TipoDocumentoRepository;

public class inizializer {

    public  void clienteStart(){
        clienteRepository clienteRepository = new clienteRepository();
        addUseCase addUseCase = new addUseCase(clienteRepository);
        findAllUseCase findAll = new findAllUseCase(clienteRepository);
        findIdUseCase findId = new findIdUseCase(clienteRepository);
        clienteDeleteUseCase delete = new clienteDeleteUseCase(clienteRepository);
        updateClienteUseCase update = new updateClienteUseCase(clienteRepository);
        clienteConsoleAdapter console = new clienteConsoleAdapter(addUseCase, findAll, findId, delete,update);

        console.start();
    }

    public void TipoDocumentoStart(){
        TipoDocumentoRepository tipoDocumentoRepository = new TipoDocumentoRepository();
        AddTipoDocumentUseCase AddTipoDocument = new AddTipoDocumentUseCase(tipoDocumentoRepository);
        DeleteTipoDocumentoUseCase DelTipoDocumento = new DeleteTipoDocumentoUseCase(tipoDocumentoRepository);
        FindTipoDocumentAllUseCase AllTipoDocumento = new FindTipoDocumentAllUseCase(tipoDocumentoRepository);
        FindTipoDocumentByIdUseCase iDTipoDocumento = new FindTipoDocumentByIdUseCase(tipoDocumentoRepository);
        UpdateTipoDocumentUseCase updateTipoDocumento = new UpdateTipoDocumentUseCase(tipoDocumentoRepository);

        TipoDocumentoConsoleAdapter console = new TipoDocumentoConsoleAdapter(AddTipoDocument, DelTipoDocumento, AllTipoDocumento, iDTipoDocumento, updateTipoDocumento);
        console.start();
    }

    public void PaisStart(){
        paisRepository paisRepository = new paisRepository();
        addpaisUseCase AddPais = new addpaisUseCase(paisRepository);
        deleteUseCase deletePais = new deleteUseCase(paisRepository);
        findAllPaisUseCase allPais = new findAllPaisUseCase(paisRepository);
        findIdPaisUseCase idPais = new findIdPaisUseCase(paisRepository);
        updateUseCase updateCliente = new updateUseCase(paisRepository);

        paisConsoleAdapter console = new paisConsoleAdapter(AddPais, allPais, idPais, deletePais, updateCliente);
        console.start();
    }

    public void CiudadStart(){
        CiudadRepository ciudadRepository = new CiudadRepository();
        AddCiudadUseCase addCiudad = new AddCiudadUseCase(ciudadRepository);
        DeleteCiudadUseCase delectCiudad = new DeleteCiudadUseCase(ciudadRepository);
        FindAllCiudadUseCase findCiudad = new FindAllCiudadUseCase(ciudadRepository);
        FindCiudadByIdUseCase idCiudad = new FindCiudadByIdUseCase(ciudadRepository);
        UpdateCiudadUseCase updateCiudad = new UpdateCiudadUseCase(ciudadRepository);

        CiudadConsoleAdapter console = new CiudadConsoleAdapter(addCiudad, delectCiudad, findCiudad, idCiudad, updateCiudad);

        console.start();

    }

    public void BarrioStart(){
        BarrioRepository barrioRepository = new BarrioRepository(); 
        AddBarrioUseCase addBarrio = new AddBarrioUseCase(barrioRepository);
        DeleteBarrioUseCase deleteBarrio = new DeleteBarrioUseCase(barrioRepository);
        FindBarrioAllUseCase allBarrios = new FindBarrioAllUseCase(barrioRepository);
        FindBarrioByIdUseCase idBarrio = new FindBarrioByIdUseCase(barrioRepository);
        UpdateBarrioUseCase updateBarrio = new UpdateBarrioUseCase(barrioRepository); 

        BarrioConsoleAdapter console = new BarrioConsoleAdapter(addBarrio, deleteBarrio, allBarrios, idBarrio, updateBarrio); 
        
        console.start();
    }
    
}
