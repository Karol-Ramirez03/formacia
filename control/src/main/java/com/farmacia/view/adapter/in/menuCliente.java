package com.farmacia.view.adapter.in;

import java.util.Scanner;

import com.farmacia.inizializer;

//data cliente
        //cliente 
        //pais
        //tipo documento
        //barrio 
        //ciudad

public class menuCliente {
    Scanner scanner = new Scanner(System.in);
    inizializer inicio = new inizializer();
    private final String titulo ="""
                
    ░█████╗░██╗░░░░░██╗███████╗███╗░░██╗████████╗███████╗░██████╗
    ██╔══██╗██║░░░░░██║██╔════╝████╗░██║╚══██╔══╝██╔════╝██╔════╝
    ██║░░╚═╝██║░░░░░██║█████╗░░██╔██╗██║░░░██║░░░█████╗░░╚█████╗░
    ██║░░██╗██║░░░░░██║██╔══╝░░██║╚████║░░░██║░░░██╔══╝░░░╚═══██╗
    ╚█████╔╝███████╗██║███████╗██║░╚███║░░░██║░░░███████╗██████╔╝
    ░╚════╝░╚══════╝╚═╝╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═════╝░
            """;

    public void showclienteMenu() {
        while (true) {
            System.out.println(titulo);
            System.out.println("1. administrar clientes");
            System.out.println("2. administrar pais");
            System.out.println("3. administrar tipos de documentos");
            System.out.println("4. administrar barrios");
            System.out.println("5. administrar ciudades");
            System.out.println("6. salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    inicio.clienteStart();
                    break;
                case 2:
                    inicio.PaisStart();
                    break;
                case 3:
                    inicio.TipoDocumentoStart();
                    break;
                case 4:
                    inicio.BarrioStart();
                    break;
                case 5:
                    inicio.CiudadStart();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
