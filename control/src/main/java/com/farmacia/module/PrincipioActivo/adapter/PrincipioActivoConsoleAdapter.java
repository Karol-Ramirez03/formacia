package com.farmacia.module.PrincipioActivo.adapter;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.PrincipioActivo.application.AddPrincipioActivoUseCase;
import com.farmacia.module.PrincipioActivo.application.DeletePrricipioActivoUseCase;
import com.farmacia.module.PrincipioActivo.application.FindPrincipioActivoAllUseCase;
import com.farmacia.module.PrincipioActivo.application.FindPrincipioActivoByIdUseCase;
import com.farmacia.module.PrincipioActivo.application.UpdatePrincipioActivoUseCase;
import com.farmacia.module.PrincipioActivo.domain.entity.PrincipioActivo;


public class PrincipioActivoConsoleAdapter {
    private final AddPrincipioActivoUseCase AddPrinc;
    private final DeletePrricipioActivoUseCase DeletePrincipio;
    private final FindPrincipioActivoAllUseCase AllPrincipio;
    private final FindPrincipioActivoByIdUseCase IdPrincipio;
    private final UpdatePrincipioActivoUseCase UpdatePrincipio;
    public PrincipioActivoConsoleAdapter(AddPrincipioActivoUseCase addPrinc,
            DeletePrricipioActivoUseCase deletePrincipio, FindPrincipioActivoAllUseCase allPrincipio,
            FindPrincipioActivoByIdUseCase idPrincipio, UpdatePrincipioActivoUseCase updatePrincipio) {
        AddPrinc = addPrinc;
        DeletePrincipio = deletePrincipio;
        AllPrincipio = allPrincipio;
        IdPrincipio = idPrincipio;
        UpdatePrincipio = updatePrincipio;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Principio Activo");
            System.out.println("2. Actualizar Principio Activo");
            System.out.println("3. Buscar Principio Activo por ID");
            System.out.println("4. Eliminar Principio Activo");
            System.out.println("5. Listar todos los Principio Activo");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre del Principio Activo: ");
                    String nombre = scanner.nextLine();
                    
                    PrincipioActivo principioActivo = new PrincipioActivo(nombre);
                    AddPrinc.execute(principioActivo);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id del Principio Activo: ");
                    int idUpdate = scanner.nextInt();

                    UpdatePrincipio.execute(idUpdate);
                    break;

                case 3:
                    System.out.print(">> Ingrese el id del Principio Activo: ");
                    int idfind = scanner.nextInt();
                    Optional<PrincipioActivo> td = IdPrincipio.execute(idfind);
                    
                    if (td.isPresent()) {
                        PrincipioActivo ptd = td.get();
                        System.out.println("Id: " + ptd.getId() + " NOMBRE: " + ptd.getNombre());
                    } else {
                        System.out.println("Principio Activo no encontrado.");
                    }
                break;
                case 4:
                    System.out.print(">> Ingrese el id del Principio Activo: ");
                    int idEliminar = scanner.nextInt();
                    DeletePrincipio.execute(idEliminar);
                    break;

                case 5:
                    List<PrincipioActivo> principio = AllPrincipio.execute();
                    for (PrincipioActivo viaP : principio) {
                        System.out.println("ID: " + viaP.getId() + " Nombre: " + viaP.getNombre());
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
