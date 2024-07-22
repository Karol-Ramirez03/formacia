package com.farmacia.view.adapter.in;

import java.util.Scanner;

import com.farmacia.inizializer;

public class MenuProducto {
    Scanner scanner = new Scanner(System.in);
    inizializer inicio = new inizializer();
    private final String titulo ="""
            
               
                ██████╗░██████╗░░█████╗░██████╗░██╗░░░██╗░█████╗░████████╗░█████╗░
                ██╔══██╗██╔══██╗██╔══██╗██╔══██╗██║░░░██║██╔══██╗╚══██╔══╝██╔══██╗
                ██████╔╝██████╔╝██║░░██║██║░░██║██║░░░██║██║░░╚═╝░░░██║░░░██║░░██║
                ██╔═══╝░██╔══██╗██║░░██║██║░░██║██║░░░██║██║░░██╗░░░██║░░░██║░░██║
                ██║░░░░░██║░░██║╚█████╔╝██████╔╝╚██████╔╝╚█████╔╝░░░██║░░░╚█████╔╝
                ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚═════╝░░╚═════╝░░╚════╝░░░░╚═╝░░░░╚════╝░
            """;
//data producto
        //producto
        //laboratorio
        //proveedor
        //unidadMedida
        //principioactivo
        //viaadministracion
    public void showproductoMenu() {
        while (true) {
            System.out.println(titulo);
            System.out.println("1. administrar productos");
            System.out.println("2. administrar laboratorios");
            System.out.println("3. administrar proveedores");
            System.out.println("4. administrar unidades de medida");
            System.out.println("5. administrar principios activos");
            System.out.println("6. administrar vias de administracion");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    inicio.ProductoStart();
                    break;
                case 2:
                    inicio.laboratorioStart();
                    break;
                case 3:
                    inicio.proveedorStart();
                    break;
                case 4:
                    inicio.UnidadMedidaStart();
                    break;
                case 5:
                    inicio.PrincipioActivoStart();
                    break;
                case 6:
                    inicio.ViaAdministracionStart();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
