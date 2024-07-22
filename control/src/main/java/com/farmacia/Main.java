package com.farmacia;

import com.farmacia.view.adapter.in.MenuInicio;

public class Main {

    public static void main(String[] args) {
      MenuInicio inicio = new MenuInicio();  
    
        String titulo = """
                █▀▀ █▀█ █▀█ █▀▄▀█ █▀█ █▀▀ █ █▀█
                █▀  █▀█ █▀▄ █░▀░█ █▀█ █▄▄ █ █▀█
                """;
        System.out.println(titulo);

        inicio.showMainMenu();
        
    }
}