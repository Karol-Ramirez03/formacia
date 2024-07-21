package com.farmacia;

import com.farmacia.module.PrincipioActivo.adapter.PrincipioActivoConsoleAdapter;
import com.farmacia.module.PrincipioActivo.application.AddPrincipioActivoUseCase;
import com.farmacia.module.PrincipioActivo.application.DeletePrricipioActivoUseCase;
import com.farmacia.module.PrincipioActivo.application.FindPrincipioActivoAllUseCase;
import com.farmacia.module.PrincipioActivo.application.FindPrincipioActivoByIdUseCase;
import com.farmacia.module.PrincipioActivo.application.UpdatePrincipioActivoUseCase;
import com.farmacia.module.PrincipioActivo.infrastruture.PrincipioActivoRepository;
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
import com.farmacia.module.laboratorio.adapter.in.LaboratorioConsoleAdapter;
import com.farmacia.module.laboratorio.application.AddLaboratorioUseCase;
import com.farmacia.module.laboratorio.application.DeleteLaboratorioUseCase;
import com.farmacia.module.laboratorio.application.FindLaboratorioAllUseCase;
import com.farmacia.module.laboratorio.application.FindLaboratorioByIdUseCase;
import com.farmacia.module.laboratorio.application.UpdateLaboratorioUseCase;
import com.farmacia.module.laboratorio.infrastructure.LaboratorioRepository;
import com.farmacia.module.pais.adapter.in.paisConsoleAdapter;
import com.farmacia.module.pais.application.addpaisUseCase;
import com.farmacia.module.pais.application.deleteUseCase;
import com.farmacia.module.pais.application.findAllPaisUseCase;
import com.farmacia.module.pais.application.findIdPaisUseCase;
import com.farmacia.module.pais.application.updateUseCase;
import com.farmacia.module.pais.infrastructure.paisRepository;
import com.farmacia.module.producto.adapter.in.ProductoConsoleAdapter;
import com.farmacia.module.producto.application.AddProductoUseCase;
import com.farmacia.module.producto.application.DeleteProductoUseCase;
import com.farmacia.module.producto.application.FindProductoAllUseCase;
import com.farmacia.module.producto.application.FindProductoByIdUseCase;
import com.farmacia.module.producto.application.UpdateProductoUseCase;
import com.farmacia.module.producto.infrastructure.ProductoRepository;
import com.farmacia.module.proveedor.adapter.in.ProveedorConsoleAdapter;
import com.farmacia.module.proveedor.application.AddProveedorUseCase;
import com.farmacia.module.proveedor.application.DelectProveedorUseCase;
import com.farmacia.module.proveedor.application.FindProveedorAllUseCase;
import com.farmacia.module.proveedor.application.FindProveedorByIdUseCase;
import com.farmacia.module.proveedor.application.UpdateProveedorUseCase;
import com.farmacia.module.proveedor.infrastructure.ProveedorRepository;
import com.farmacia.module.tipodocumento.adapter.in.TipoDocumentoConsoleAdapter;
import com.farmacia.module.tipodocumento.application.AddTipoDocumentUseCase;
import com.farmacia.module.tipodocumento.application.DeleteTipoDocumentoUseCase;
import com.farmacia.module.tipodocumento.application.FindTipoDocumentAllUseCase;
import com.farmacia.module.tipodocumento.application.FindTipoDocumentByIdUseCase;
import com.farmacia.module.tipodocumento.application.UpdateTipoDocumentUseCase;
import com.farmacia.module.tipodocumento.infrastructure.TipoDocumentoRepository;
import com.farmacia.module.unidadMedida.adapter.in.UnidadMedidaConsoleAdapter;
import com.farmacia.module.unidadMedida.application.AddUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.application.DeleteUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.application.FindUnidadMedidaByIdUseCase;
import com.farmacia.module.unidadMedida.application.FindUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.application.UpdateUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.infrastructure.UnidadMedidaRepository;
import com.farmacia.module.viaAdministracion.adapter.in.ViaAdministracionConsoleAdapter;
import com.farmacia.module.viaAdministracion.application.AddViaAdministraccionUseCase;
import com.farmacia.module.viaAdministracion.application.DeleteViaAdministracionUseCase;
import com.farmacia.module.viaAdministracion.application.FindViaAdministracionAllUseCase;
import com.farmacia.module.viaAdministracion.application.FindViaAdministracionByIDUseCase;
import com.farmacia.module.viaAdministracion.application.UpdateViaAdministracionUseCase;
import com.farmacia.module.viaAdministracion.infrastructure.ViaAdministracionRepository;

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


    //PRODUCTOS
    public void UnidadMedidaStart(){
        UnidadMedidaRepository medidaRepository = new UnidadMedidaRepository();
         AddUnidadMedidaUseCase addUnidad = new AddUnidadMedidaUseCase(medidaRepository);
         DeleteUnidadMedidaUseCase deleteUnidad = new DeleteUnidadMedidaUseCase(medidaRepository);
         FindUnidadMedidaUseCase allUnidad = new FindUnidadMedidaUseCase(medidaRepository);
         FindUnidadMedidaByIdUseCase idUnidad = new FindUnidadMedidaByIdUseCase(medidaRepository);
         UpdateUnidadMedidaUseCase updateUnidad = new UpdateUnidadMedidaUseCase(medidaRepository);

         UnidadMedidaConsoleAdapter console = new UnidadMedidaConsoleAdapter(addUnidad, deleteUnidad, allUnidad, idUnidad, updateUnidad);
         
         console.start();
    }
    

    //PRODUCTO
    public void ProductoStart(){
        ProductoRepository productoRepository = new ProductoRepository();
        AddProductoUseCase addProduct = new AddProductoUseCase(productoRepository);
        DeleteProductoUseCase delProduct = new DeleteProductoUseCase(productoRepository);
        FindProductoAllUseCase allProduct = new FindProductoAllUseCase(productoRepository);
        FindProductoByIdUseCase idProduct = new FindProductoByIdUseCase(productoRepository);
        UpdateProductoUseCase updProduct = new UpdateProductoUseCase(productoRepository);

        ProductoConsoleAdapter console = new ProductoConsoleAdapter(addProduct, allProduct, idProduct, delProduct, updProduct);
        console.start();
    }

    //VIA ADMINISTRACION
    public void ViaAdministracionStart(){
        ViaAdministracionRepository viaRepository = new ViaAdministracionRepository();
        AddViaAdministraccionUseCase addVia = new AddViaAdministraccionUseCase(viaRepository);
        DeleteViaAdministracionUseCase delVia = new DeleteViaAdministracionUseCase(viaRepository);
        FindViaAdministracionAllUseCase allVia = new FindViaAdministracionAllUseCase(viaRepository);
        FindViaAdministracionByIDUseCase idVia = new FindViaAdministracionByIDUseCase(viaRepository);
        UpdateViaAdministracionUseCase updVia = new UpdateViaAdministracionUseCase(viaRepository);

        ViaAdministracionConsoleAdapter console = new ViaAdministracionConsoleAdapter(addVia, delVia, allVia, idVia, updVia);
        console.start();

    }
    //PRINCIPIO ACTIVO
    public void PrincipioActivoStart(){
        PrincipioActivoRepository actRepository = new PrincipioActivoRepository();
        AddPrincipioActivoUseCase addAct = new AddPrincipioActivoUseCase(actRepository);
        DeletePrricipioActivoUseCase delAct = new DeletePrricipioActivoUseCase(actRepository);
        FindPrincipioActivoAllUseCase allAct = new FindPrincipioActivoAllUseCase(actRepository);
        FindPrincipioActivoByIdUseCase idAct = new FindPrincipioActivoByIdUseCase(actRepository);
        UpdatePrincipioActivoUseCase updAct = new UpdatePrincipioActivoUseCase(actRepository);

        PrincipioActivoConsoleAdapter console = new PrincipioActivoConsoleAdapter(addAct, delAct, allAct, idAct, updAct); 
        console.start();
    }



    public void laboratorioStart(){
        LaboratorioRepository laboratorioRepository = new LaboratorioRepository();
        AddLaboratorioUseCase AddLabor = new  AddLaboratorioUseCase(laboratorioRepository);
        DeleteLaboratorioUseCase delLabor = new DeleteLaboratorioUseCase(laboratorioRepository);
        FindLaboratorioAllUseCase allLabor = new FindLaboratorioAllUseCase(laboratorioRepository);
        FindLaboratorioByIdUseCase idLabor = new FindLaboratorioByIdUseCase(laboratorioRepository);
        UpdateLaboratorioUseCase updLabor = new UpdateLaboratorioUseCase(laboratorioRepository) ;

        LaboratorioConsoleAdapter console = new LaboratorioConsoleAdapter(AddLabor, delLabor, allLabor, idLabor, updLabor);

        console.start();
    }


    //PROVEEDOR
    public void proveedorStart(){
        ProveedorRepository proveedorRepository = new ProveedorRepository();
        AddProveedorUseCase addProveedor = new AddProveedorUseCase(proveedorRepository);
        DelectProveedorUseCase delProveedor = new DelectProveedorUseCase(proveedorRepository);
        FindProveedorAllUseCase allProveedor = new FindProveedorAllUseCase(proveedorRepository);
        FindProveedorByIdUseCase idProveedor = new FindProveedorByIdUseCase(proveedorRepository);
        UpdateProveedorUseCase updProveedor = new UpdateProveedorUseCase(proveedorRepository);

        ProveedorConsoleAdapter console = new ProveedorConsoleAdapter(addProveedor, delProveedor, allProveedor, idProveedor, updProveedor);
        console.start();
    }
}
 