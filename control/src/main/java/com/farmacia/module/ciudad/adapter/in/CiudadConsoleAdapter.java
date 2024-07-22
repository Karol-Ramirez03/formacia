package com.farmacia.module.ciudad.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.ciudad.application.AddCiudadUseCase;
import com.farmacia.module.ciudad.application.DeleteCiudadUseCase;
import com.farmacia.module.ciudad.application.FindAllCiudadUseCase;
import com.farmacia.module.ciudad.application.FindCiudadByIdUseCase;
import com.farmacia.module.ciudad.application.UpdateCiudadUseCase;
import com.farmacia.module.ciudad.domain.entity.Ciudad;


public class CiudadConsoleAdapter {
    private final AddCiudadUseCase addCity;
    private final DeleteCiudadUseCase deleteCity;
    private final FindAllCiudadUseCase allCity;
    private final FindCiudadByIdUseCase idCity;
    private final UpdateCiudadUseCase updateCity;

    

public CiudadConsoleAdapter(AddCiudadUseCase addCity, DeleteCiudadUseCase deleteCity, FindAllCiudadUseCase allCity,
            FindCiudadByIdUseCase idCity, UpdateCiudadUseCase updateCity) {
        this.addCity = addCity;
        this.deleteCity = deleteCity;
        this.allCity = allCity;
        this.idCity = idCity;
        this.updateCity = updateCity;
    }



public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear ciudad");
            System.out.println("2. Actualizar ciudad");
            System.out.println("3. Buscar ciudad por ID");
            System.out.println("4. Eliminar ciudad");
            System.out.println("5. Listar todos ciudad");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre de la ciudad: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Ingrese el id del pais de la ciudad: ");
                    int id_pais = scanner.nextInt();

                    Ciudad city = new Ciudad(nombres,id_pais);                    
                    addCity.execute(city);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id de la ciudad a actualizar: ");
                    int idUpdate = scanner.nextInt();
                    Optional<Ciudad> ciudadExistente = idCity.execute(idUpdate);

                    if (!ciudadExistente.isPresent()) {
                        System.out.println("ciudad no encontrado.");
                        break;
                    }

                    Ciudad ciudadActual = ciudadExistente.get();
                    
                    boolean actualizar = true;
                    while (actualizar) {
                        System.out.println("Seleccione el campo a actualizar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. id pais");
                        System.out.println("3. Terminar actualización");
                        int campo = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        switch (campo) {
                            case 1:
                                System.out.print(">> Ingrese el nuevo nombre: ");
                                ciudadActual.setNombre(scanner.nextLine());
                                
                                break;
                            case 2:
                                System.out.print(">> Ingrese el id del pais: ");
                                ciudadActual.setid_pais(scanner.nextInt());
                                break;
                            case 3:
                                actualizar = false;
                                break;
                            default:
                                System.out.println("Opción inválida, intente de nuevo.");
                        }
                    }
                    updateCity.execute(ciudadActual);
                break;


                case 3:
                    
                    System.out.print(">> Ingrese el id de la ciudad: ");
                    int idbuscar = scanner.nextInt();
                    Optional<Ciudad> Ciudadid = idCity.execute(idbuscar);
                    if (Ciudadid.isPresent()) {
                        Ciudad presentCiudad = Ciudadid.get();
                        System.out.println("Id: " + presentCiudad.getId() + " NOMBRE: " + presentCiudad.getNombre() + " ID PAIS: " + presentCiudad.getid_pais());
                    } else {
                        System.out.println("Ciudad no encontrado.");
                    }

                    break;

                case 4:
                        System.out.print(">> Ingrese el id de la ciudad: ");
                        int iddelete = scanner.nextInt();
                        deleteCity.execute(iddelete);
                    break;

                case 5:
                    List<Ciudad> listCiudad = allCity.execute();
                    for (Ciudad ciudad :listCiudad ){
                        System.out.println("Id: " + ciudad.getId() + " NOMBRE: " + ciudad.getNombre() + " PAIS: " + ciudad.getid_pais());
                        System.out.println("---------");
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
