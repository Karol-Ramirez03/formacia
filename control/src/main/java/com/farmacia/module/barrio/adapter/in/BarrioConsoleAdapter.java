package com.farmacia.module.barrio.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.barrio.application.AddBarrioUseCase;
import com.farmacia.module.barrio.application.DeleteBarrioUseCase;
import com.farmacia.module.barrio.application.FindBarrioAllUseCase;
import com.farmacia.module.barrio.application.FindBarrioByIdUseCase;
import com.farmacia.module.barrio.application.UpdateBarrioUseCase;
import com.farmacia.module.barrio.domain.entity.Barrio;



public class BarrioConsoleAdapter {
        private final AddBarrioUseCase addBarrio; 
        private final DeleteBarrioUseCase delectBarrio;
        private final FindBarrioAllUseCase AllBarrio;
        private final FindBarrioByIdUseCase IdBarrio;
        private final UpdateBarrioUseCase updateBarrio;

    


public BarrioConsoleAdapter(AddBarrioUseCase addBarrio, DeleteBarrioUseCase delectBarrio,
                FindBarrioAllUseCase allBarrio, FindBarrioByIdUseCase idBarrio, UpdateBarrioUseCase updateBarrio) {
            this.addBarrio = addBarrio;
            this.delectBarrio = delectBarrio;
            AllBarrio = allBarrio;
            IdBarrio = idBarrio;
            this.updateBarrio = updateBarrio;
        }




public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Barrio");
            System.out.println("2. Actualizar Barrio");
            System.out.println("3. Buscar Barrio por ID");
            System.out.println("4. Eliminar Barrio");
            System.out.println("5. Listar todos Barrio");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre del barrio: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Ingrese el id de la ciudad ");
                    int id_ciudad = scanner.nextInt();

                    Barrio barrio = new Barrio(nombres,id_ciudad);                    
                    addBarrio.execute(barrio);

                    break;

                case 2:
                    System.out.print(">> Ingrese el id de la Barrio a actualizar: ");
                    int idUpdate = scanner.nextInt();
                    Optional<Barrio> BarrioExistente = IdBarrio.execute(idUpdate);

                    if (!BarrioExistente.isPresent()) {
                        System.out.println("barrio no encontrado.");
                        break;
                    }

                    Barrio BarrioActual = BarrioExistente.get();
                    
                    boolean actualizar = true;
                    while (actualizar) {
                        System.out.println("Seleccione el campo a actualizar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. id ciudad");
                        System.out.println("3. Terminar actualización");
                        int campo = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        switch (campo) {
                            case 1:
                                System.out.print(">> Ingrese el nuevo nombre: ");
                                BarrioActual.setNombre(scanner.nextLine());
                                
                                break;
                            case 2:
                                System.out.print(">> Ingrese los nuevos apellidos: ");
                                BarrioActual.setCiudad(scanner.nextInt());
                                break;
                            case 3:
                                actualizar = false;
                                break;
                            default:
                                System.out.println("Opción inválida, intente de nuevo.");
                        }
                    }
                    updateBarrio.execute(BarrioActual);
                break;


                case 3:
                    
                    System.out.print(">> Ingrese el id de la persona: ");
                    int idbuscar = scanner.nextInt();
                    Optional<Barrio> Barrioid = IdBarrio.execute(idbuscar);
                    if (Barrioid.isPresent()) {
                        Barrio presentBarrio = Barrioid.get();
                        System.out.println("Id: " + presentBarrio.getId() + " NOMBRE: " + presentBarrio.getNombre() + " ID CIUDAD: " + presentBarrio.getCiudad());
                    } else {
                        System.out.println("Barrio no encontrado.");
                    }

                    break;

                case 4:
                        System.out.print(">> Ingrese el id de la persona: ");
                        int iddelete = scanner.nextInt();
                        delectBarrio.execute(iddelete);
                    break;

                case 5:
                    List<Barrio> listBarrio = AllBarrio.execute();
                    for (Barrio Barrio : listBarrio ){
                        System.out.println("Id: " + Barrio.getId() + " NOMBRE: " + Barrio.getNombre() + " ciudad: " + Barrio.getCiudad());
                        System.out.println("---------");
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
