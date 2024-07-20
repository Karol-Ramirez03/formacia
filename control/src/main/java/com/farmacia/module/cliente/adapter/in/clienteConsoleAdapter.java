package com.farmacia.module.cliente.adapter.in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.cliente.application.addUseCase;
import com.farmacia.module.cliente.application.clienteDeleteUseCase;
import com.farmacia.module.cliente.application.findAllUseCase;
import com.farmacia.module.cliente.application.findIdUseCase;
import com.farmacia.module.cliente.application.updateClienteUseCase;
import com.farmacia.module.cliente.domain.entity.cliente;

public class clienteConsoleAdapter {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final addUseCase clienteAdd;
    private final findAllUseCase clienteFindAll;
    private final findIdUseCase findId;
    private final clienteDeleteUseCase clienteDelete;
    private final updateClienteUseCase updateCliente;


    


    public clienteConsoleAdapter(addUseCase clienteAdd, findAllUseCase clienteFindAll, findIdUseCase findId,
            clienteDeleteUseCase clienteDelete, updateClienteUseCase updateCliente) {
        this.clienteAdd = clienteAdd;
        this.clienteFindAll = clienteFindAll;
        this.findId = findId;
        this.clienteDelete = clienteDelete;
        this.updateCliente = updateCliente;
    }





    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear cliente");
            System.out.println("2. Actualizar cliente");
            System.out.println("3. Buscar cliente por ID");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Listar todos clientes");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el id de la persona: ");
                    String id = scanner.nextLine();
                    System.out.print(">> Ingrese el nombre del cliente: ");
                    String nombres = scanner.nextLine();
                    System.out.print(">> Ingrese el apellido de la persona: ");
                    String apellidos = scanner.nextLine();
                    System.out.print(">> Ingrese el tipo de documento (ID numérico): ");
                    int tipoDocumento = scanner.nextInt();
                    System.out.print(">> Ingrese la edad de la persona: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Ingrese la fecha de nacimiento del cliente (dd/MM/yyyy): ");
                    String fechaNacimientoStr = scanner.nextLine();
                    Date fechaNacimiento = null;
                    
                    try {
                        fechaNacimiento = dateFormat.parse(fechaNacimientoStr);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
                        break;
                    }
        
                    System.out.print("Ingrese el id del barrio del cliente: ");
                    int barrio = scanner.nextInt();

                    // Crear el cliente sin fechaRegistro
                    cliente cliente = new cliente(id, nombres, tipoDocumento, apellidos, edad, fechaNacimiento, barrio);                    
                    clienteAdd.addcliente(cliente);
                    break;

                case 2:
                System.out.print(">> Ingrese el id del cliente a actualizar: ");
                String idUpdate = scanner.nextLine();
                Optional<cliente> clienteExistente = findId.execute(idUpdate);

                if (!clienteExistente.isPresent()) {
                    System.out.println("Cliente no encontrado.");
                    break;
                }

                cliente clienteActual = clienteExistente.get();
                
                boolean actualizar = true;
                while (actualizar) {
                    System.out.println("Seleccione el campo a actualizar:");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellidos");
                    System.out.println("3. Edad");
                    System.out.println("4. Terminar actualización");
                    int campo = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente

                    switch (campo) {
                        case 1:
                            System.out.print(">> Ingrese el nuevo nombre: ");
                            clienteActual.setNombre(scanner.nextLine());
                            
                            break;
                        case 2:
                            System.out.print(">> Ingrese los nuevos apellidos: ");
                            clienteActual.setApellidos(scanner.nextLine());
                            break;
                        case 3:
                            System.out.print(">> Ingrese la nueva edad: ");
                            clienteActual.setEdad(scanner.nextInt());
                            scanner.nextLine(); // Consumir el salto de línea pendiente
                            break;
                        case 4:
                            actualizar = false;
                            break;
                        default:
                            System.out.println("Opción inválida, intente de nuevo.");
                    }
                }
                updateCliente.execute(clienteActual);
                break;


                case 3:
                    System.out.print(">> Ingrese el id de la persona: ");
                    String idbuscar = scanner.nextLine();
                    Optional<cliente> clienteid = findId.execute(idbuscar);
                    if (clienteid.isPresent()) {
                        cliente presentclient = clienteid.get();
                        System.out.println("Id: " + presentclient.getId() + " NOMBRE: " + presentclient.getNombre() + " APELLIDOS: " + presentclient.getApellidos() + " EDAD: " + presentclient.getEdad());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }

                    break;

                case 4:
                        System.out.print(">> Ingrese el id de la persona: ");
                        String iddelete = scanner.nextLine();
                        clienteDelete.execute(iddelete);

                    break;

                case 5:
                    List<cliente> listclientes = clienteFindAll.findAll();
                    for (cliente client :listclientes ){
                        System.out.println("Id: " + client.getId() + " NOMBRE: " + client.getNombre() + " APELLIDOS: " + client.getApellidos() + " EDAD: " + client.getEdad());
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

