package com.farmacia.view.adapter.in;

import java.util.Scanner;


public class MenuInicio {

    Scanner scanner = new Scanner(System.in);
    MenuProducto producto = new MenuProducto();
    menuCliente cliente = new menuCliente();
    

    public void showMainMenu() {
        while (true) {
            
            System.out.println("1. Cliente");
            System.out.println("2. productos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    cliente.showclienteMenu();
                  
                    break;
                case 2:
                    producto.showproductoMenu();
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
