package com.farmacia.module.proveedor.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.proveedor.application.AddProveedorUseCase;
import com.farmacia.module.proveedor.application.DelectProveedorUseCase;
import com.farmacia.module.proveedor.application.FindProveedorAllUseCase;
import com.farmacia.module.proveedor.application.FindProveedorByIdUseCase;
import com.farmacia.module.proveedor.application.UpdateProveedorUseCase;
import com.farmacia.module.proveedor.domain.entity.Proveedor;

public class ProveedorConsoleAdapter {
    private final AddProveedorUseCase addProveedor;
    private final DelectProveedorUseCase delProveedor;
    private final FindProveedorAllUseCase allProveedor;
    private final FindProveedorByIdUseCase idProveedor;
    private final UpdateProveedorUseCase updProveedor;

    



public ProveedorConsoleAdapter(AddProveedorUseCase addProveedor, DelectProveedorUseCase delProveedor,
            FindProveedorAllUseCase allProveedor, FindProveedorByIdUseCase idProveedor,
            UpdateProveedorUseCase updProveedor) {
        this.addProveedor = addProveedor;
        this.delProveedor = delProveedor;
        this.allProveedor = allProveedor;
        this.idProveedor = idProveedor;
        this.updProveedor = updProveedor;
    }





public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Proveedor");
            System.out.println("2. Actualizar Proveedor");
            System.out.println("3. Buscar Proveedor por ID");
            System.out.println("4. Eliminar Proveedor");
            System.out.println("5. Listar todos los Proveedores");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre de Proveedor: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Ingrese el cointacto del Proveedor: ");
                    String proveedor = scanner.nextLine();

                    Proveedor prov = new Proveedor(nombres, proveedor);                    
                    addProveedor.execute(prov);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id de la Proveedor a actualizar: ");
                    int idUpdate = scanner.nextInt();
                    Optional<Proveedor> ProveedorExistente = idProveedor.execute(idUpdate);

                    if (!ProveedorExistente.isPresent()) {
                        System.out.println("Proveedor no encontrado.");
                        break;
                    }

                    Proveedor ProveedorActual = ProveedorExistente.get();
                    
                    boolean actualizar = true;
                    while (actualizar) {
                        System.out.println("Seleccione el campo a actualizar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Descripcion");
                        System.out.println("3. Terminar actualización");
                        int campo = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        switch (campo) {
                            case 1:
                                System.out.print(">> Ingrese el nuevo nombre: ");
                                ProveedorActual.setNombre(scanner.nextLine());
                                
                                break;
                            case 2:
                                System.out.print(">> Ingrese el nuevo contacto: ");
                                ProveedorActual.setContacto(scanner.nextLine());
                                break;
                            case 3:
                                actualizar = false;
                                break;
                            default:
                                System.out.println("Opción inválida, intente de nuevo.");
                        }
                    }
                    updProveedor.execute(ProveedorActual);
                break;


                case 3:
                    
                    System.out.print(">> Ingrese el id de la Proveedor: ");
                    int idbuscar = scanner.nextInt();
                    Optional<Proveedor> Proveedorid = idProveedor.execute(idbuscar);

                    if (Proveedorid.isPresent()) {
                        Proveedor presentProveedor = Proveedorid.get();
                        System.out.println("Id: " + presentProveedor.getId() + " NOMBRE: " + presentProveedor.getNombre() + " CONTACTO: " + presentProveedor.getContacto());
                    } else {
                        System.out.println("Proveedor no encontrado.");
                    }

                    break;

                case 4:
                        System.out.print(">> Ingrese el id de  Proveedor: ");
                        int iddelete = scanner.nextInt();
                        delProveedor.execute(iddelete);
                    break;

                case 5:
                    List<Proveedor> listProveedor = allProveedor.execute();
                    for (Proveedor Proveedor :listProveedor ){
                        System.out.println("Id: " + Proveedor.getId() + " NOMBRE: " + Proveedor.getNombre() + " CONTACTO: " + Proveedor.getContacto());
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