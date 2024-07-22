package com.farmacia.module.unidadMedida.adapter.in;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.unidadMedida.application.AddUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.application.DeleteUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.application.FindUnidadMedidaByIdUseCase;
import com.farmacia.module.unidadMedida.application.FindUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.application.UpdateUnidadMedidaUseCase;
import com.farmacia.module.unidadMedida.domain.entity.UnidadMedida;

public class UnidadMedidaConsoleAdapter {
    private final AddUnidadMedidaUseCase addUnidad;
    private final DeleteUnidadMedidaUseCase deleteUnidad;
    private final FindUnidadMedidaUseCase allUnidad;
    private final FindUnidadMedidaByIdUseCase idUnidad;
    private final UpdateUnidadMedidaUseCase updateUnidad;

    public UnidadMedidaConsoleAdapter(AddUnidadMedidaUseCase addUnidad, DeleteUnidadMedidaUseCase deleteUnidad,FindUnidadMedidaUseCase allUnidad, FindUnidadMedidaByIdUseCase idUnidad, UpdateUnidadMedidaUseCase updateUnidad) {
        this.addUnidad = addUnidad;
        this.deleteUnidad = deleteUnidad;
        this.allUnidad = allUnidad;
        this.idUnidad = idUnidad;
        this.updateUnidad = updateUnidad;
    }

    
    
public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear unidad medida");
            System.out.println("2. Actualizar unidad medida");
            System.out.println("3. Buscar unidad medida por ID");
            System.out.println("4. Eliminar unidad medida");
            System.out.println("5. Listar todos los unidad medida");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    
                    System.out.print(">> Ingrese el nombre de unidad medida: ");
                    String nombre = scanner.nextLine();
                    UnidadMedida medida = new UnidadMedida(nombre);
                    addUnidad.execute(medida);
                    break;

                case 2:
                    System.out.print(">> Ingrese el id de unidad medida: ");
                    int idUpdate = scanner.nextInt();

                    updateUnidad.execute(idUpdate);
                    break;

                case 3:
                    System.out.print(">> Ingrese el id de unidad medida: ");
                    int idfind = scanner.nextInt();
                    Optional<UnidadMedida> td = idUnidad.execute(idfind);

                    if (td.isPresent()) {
                        UnidadMedida ptd = td.get();
                        System.out.println("Id: " + ptd.getId() + " NOMBRE: " + ptd.getDescripcion());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                break;

                case 4:
                    System.out.print(">> Ingrese el id de unidad medida: ");
                    int idEliminar = scanner.nextInt();
                    deleteUnidad.execute(idEliminar);
                    break;

                case 5:
                    List<UnidadMedida> unidades = allUnidad.execute();
                    for (UnidadMedida unid : unidades) {
                        System.out.println("ID: " + unid.getId() + " Nombre: " + unid.getDescripcion());
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