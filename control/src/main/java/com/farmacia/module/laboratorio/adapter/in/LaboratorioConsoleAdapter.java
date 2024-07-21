package com.farmacia.module.laboratorio.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.laboratorio.application.AddLaboratorioUseCase;
import com.farmacia.module.laboratorio.application.DeleteLaboratorioUseCase;
import com.farmacia.module.laboratorio.application.FindLaboratorioAllUseCase;
import com.farmacia.module.laboratorio.application.FindLaboratorioByIdUseCase;
import com.farmacia.module.laboratorio.application.UpdateLaboratorioUseCase;
import com.farmacia.module.laboratorio.domain.entity.Laboratorio;
import com.farmacia.module.proveedor.application.DelectProveedorUseCase;

public class LaboratorioConsoleAdapter {
    private final AddLaboratorioUseCase AddLabor;
    private final DeleteLaboratorioUseCase delLabor;
    private final FindLaboratorioAllUseCase allLabor;
    private final FindLaboratorioByIdUseCase idLabor;
    private final UpdateLaboratorioUseCase updLabor;

    

    public LaboratorioConsoleAdapter(AddLaboratorioUseCase addLabor, DeleteLaboratorioUseCase delLabor,
            FindLaboratorioAllUseCase allLabor, FindLaboratorioByIdUseCase idLabor, UpdateLaboratorioUseCase updLabor) {
        AddLabor = addLabor;
        this.delLabor = delLabor;
        this.allLabor = allLabor;
        this.idLabor = idLabor;
        this.updLabor = updLabor;
    }



    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Laboratorio");
            System.out.println("2. Actualizar Laboratorio");
            System.out.println("3. Buscar Laboratorio por ID");
            System.out.println("4. Eliminar Laboratorio");
            System.out.println("5. Listar todos los Laboratorios");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre del Laboratorio: ");
                    String nombre = scanner.nextLine();
                    
                    Laboratorio labor = new Laboratorio(nombre);
                    AddLabor.add(labor);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id del Laboratorio: ");
                    int idUpdate = scanner.nextInt();

                    updLabor.execute(idUpdate);
                    break;

                case 3:
                    System.out.print(">> Ingrese el id del Laboratorio: ");
                    int idfind = scanner.nextInt();
                    Optional<Laboratorio> td = idLabor.execute(idfind);
                    
                    if (td.isPresent()) {
                        Laboratorio ptd = td.get();
                        System.out.println("Id: " + ptd.getId() + " NOMBRE: " + ptd.getNombre());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                break;
                case 4:
                    System.out.print(">> Ingrese el id del Laboratorio: ");
                    int idEliminar = scanner.nextInt();
                    delLabor.execut(idEliminar);
                    break;

                case 5:
                    List<Laboratorio> laboratorio = allLabor.execute();
                    for (Laboratorio lab : laboratorio) {
                        System.out.println("ID: " + lab.getId() + " Nombre: " + lab.getNombre());
                        System.out.println("--------------------");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close(); // Cerrar el scanner al salir
                    return; // Salir del método start()

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }

}
