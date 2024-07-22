package com.farmacia.module.tipodocumento.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.farmacia.module.tipodocumento.application.AddTipoDocumentUseCase;
import com.farmacia.module.tipodocumento.application.DeleteTipoDocumentoUseCase;
import com.farmacia.module.tipodocumento.application.FindTipoDocumentAllUseCase;
import com.farmacia.module.tipodocumento.application.FindTipoDocumentByIdUseCase;
import com.farmacia.module.tipodocumento.application.UpdateTipoDocumentUseCase;
import com.farmacia.module.tipodocumento.domain.entity.TipoDocumento;

public class TipoDocumentoConsoleAdapter {

    private final AddTipoDocumentUseCase addDocument;
    private final DeleteTipoDocumentoUseCase deleteDocument;
    private final FindTipoDocumentAllUseCase allDocuments;
    private final FindTipoDocumentByIdUseCase idDocuments;
    private final UpdateTipoDocumentUseCase updateDocument;

    


public TipoDocumentoConsoleAdapter(AddTipoDocumentUseCase addDocument, DeleteTipoDocumentoUseCase deleteDocument,
            FindTipoDocumentAllUseCase allDocuments, FindTipoDocumentByIdUseCase idDocuments, UpdateTipoDocumentUseCase updateDocument) {
        this.addDocument = addDocument;
        this.deleteDocument = deleteDocument;
        this.allDocuments = allDocuments;
        this.idDocuments = idDocuments;
        this.updateDocument = updateDocument;
    }




public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear tipo documento");
            System.out.println("2. Actualizar tipo documento");
            System.out.println("3. Buscar tipo documento por ID");
            System.out.println("4. Eliminar tipo documento");
            System.out.println("5. Listar todos los tipo documentoes");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    
                    System.out.print(">> Ingrese el nombre del tipo documento: ");
                    String nombre = scanner.nextLine();
                    
                    TipoDocumento Documento = new TipoDocumento(nombre);
                    addDocument.execute(Documento);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id del tipo documento: ");
                    int idUpdate = scanner.nextInt();

                    updateDocument.execute(idUpdate);
                    break;

                case 3:
                    System.out.print(">> Ingrese el id del tipo documento: ");
                    int idfind = scanner.nextInt();
                    Optional<TipoDocumento> td = idDocuments.execute(idfind);

                    if (td.isPresent()) {
                        TipoDocumento ptd = td.get();
                        System.out.println("Id: " + ptd.getId() + " NOMBRE: " + ptd.getNombre());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                break;

                case 4:
                    System.out.print(">> Ingrese el id del tipo documento: ");
                    int idEliminar = scanner.nextInt();
                    deleteDocument.execute(idEliminar);
                    break;

                case 5:
                    List<TipoDocumento> tipoDocumento = allDocuments.findAll();
                    for (TipoDocumento tipo : tipoDocumento) {
                        System.out.println("ID: " + tipo.getId() + " Nombre: " + tipo.getNombre());
                        System.out.println("--------------------");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    return; // Salir del método start()

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
}}
