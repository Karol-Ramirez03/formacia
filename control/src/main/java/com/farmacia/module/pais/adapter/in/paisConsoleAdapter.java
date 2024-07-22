package com.farmacia.module.pais.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.farmacia.module.pais.application.addpaisUseCase;
import com.farmacia.module.pais.application.deleteUseCase;
import com.farmacia.module.pais.application.updateUseCase;
import com.farmacia.module.pais.domain.entity.Pais;
import com.farmacia.module.pais.application.findAllPaisUseCase;
import com.farmacia.module.pais.application.findIdPaisUseCase;



public class paisConsoleAdapter {
    private final addpaisUseCase addPaisUseCase;
    private final findAllPaisUseCase findAllPaisUseCase;
    private final findIdPaisUseCase findPaisByIdUseCase;
    private final deleteUseCase deletePaisUseCase;
    private final updateUseCase updatePaisUseCase;

    public paisConsoleAdapter(addpaisUseCase addPaisUseCase, findAllPaisUseCase findAllPaisUseCase, findIdPaisUseCase findPaisByIdUseCase, deleteUseCase deletePaisUseCase, updateUseCase updatePaisUseCase) {
        this.addPaisUseCase = addPaisUseCase;
        this.findAllPaisUseCase = findAllPaisUseCase;
        this.findPaisByIdUseCase = findPaisByIdUseCase;
        this.deletePaisUseCase = deletePaisUseCase;
        this.updatePaisUseCase = updatePaisUseCase;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear país");
            System.out.println("2. Actualizar país");
            System.out.println("3. Buscar país por ID");
            System.out.println("4. Eliminar país");
            System.out.println("5. Listar todos los países");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre del país: ");
                    String nombre = scanner.nextLine();
                    
                    Pais pais = new Pais(nombre);
                    addPaisUseCase.execute(pais);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id del país: ");
                    int idUpdate = scanner.nextInt();

                    updatePaisUseCase.execute(idUpdate);
                    break;

                case 3:
                    System.out.print(">> Ingrese el id del país: ");
                    int idfind = scanner.nextInt();
                    Optional<Pais> td = findPaisByIdUseCase.execute(idfind);
                    
                    if (td.isPresent()) {
                        Pais ptd = td.get();
                        System.out.println("Id: " + ptd.getId() + " NOMBRE: " + ptd.getNombre());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                break;
                case 4:
                    System.out.print(">> Ingrese el id del país: ");
                    int idEliminar = scanner.nextInt();
                    deletePaisUseCase.execute(idEliminar);
                    break;

                case 5:
                    List<Pais> paises = findAllPaisUseCase.findAll();
                    for (Pais pais2 : paises) {
                        System.out.println("ID: " + pais2.getId() + " Nombre: " + pais2.getNombre());
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
    }
}
