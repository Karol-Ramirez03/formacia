package com.farmacia.module.viaAdministracion.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


import com.farmacia.module.viaAdministracion.application.AddViaAdministraccionUseCase;
import com.farmacia.module.viaAdministracion.application.DeleteViaAdministracionUseCase;
import com.farmacia.module.viaAdministracion.application.FindViaAdministracionAllUseCase;
import com.farmacia.module.viaAdministracion.application.FindViaAdministracionByIDUseCase;
import com.farmacia.module.viaAdministracion.application.UpdateViaAdministracionUseCase;
import com.farmacia.module.viaAdministracion.domain.entity.ViaAdministracion;

public class ViaAdministracionConsoleAdapter {
    private final AddViaAdministraccionUseCase addVia;
    private final DeleteViaAdministracionUseCase DeleteVia;
    private final FindViaAdministracionAllUseCase AllVia;
    private final FindViaAdministracionByIDUseCase IdVia;
    private final UpdateViaAdministracionUseCase updateVia;
    
    public ViaAdministracionConsoleAdapter(AddViaAdministraccionUseCase addVia, DeleteViaAdministracionUseCase deleteVia, FindViaAdministracionAllUseCase allVia,
            FindViaAdministracionByIDUseCase idVia, UpdateViaAdministracionUseCase updateVia) {
        this.addVia = addVia;
        DeleteVia = deleteVia;
        AllVia = allVia;
        IdVia = idVia;
        this.updateVia = updateVia;
    }

    
public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Via Administracion");
            System.out.println("2. Actualizar Via Administracion");
            System.out.println("3. Buscar Via Administracion por ID");
            System.out.println("4. Eliminar Via Administracion");
            System.out.println("5. Listar todos las Via Administracion");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el nombre de la Via Administracion: ");
                    String nombre = scanner.nextLine();
                    
                    ViaAdministracion viaAdm = new ViaAdministracion(nombre);
                    addVia.execute(viaAdm);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id del Via Administracion: ");
                    int idUpdate = scanner.nextInt();

                    updateVia.execute(idUpdate);
                    break;

                case 3:
                    System.out.print(">> Ingrese el id del Via Administracion: ");
                    int idfind = scanner.nextInt();
                    Optional<ViaAdministracion> td = IdVia.execute(idfind);
                    
                    if (td.isPresent()) {
                        ViaAdministracion ptd = td.get();
                        System.out.println("Id: " + ptd.getId() + " NOMBRE: " + ptd.getDescripcion());
                    } else {
                        System.out.println("Via Administracion no encontrado.");
                    }
                break;
                case 4:
                    System.out.print(">> Ingrese el id del Via Administracion: ");
                    int idEliminar = scanner.nextInt();
                    DeleteVia.execute(idEliminar);
                    break;

                case 5:
                    List<ViaAdministracion> viaADM = AllVia.execute();
                    for (ViaAdministracion via : viaADM) {
                        System.out.println("ID: " + via.getId() + " Nombre: " + via.getDescripcion());
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
        }}

}
