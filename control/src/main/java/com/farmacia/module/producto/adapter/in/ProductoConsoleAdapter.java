package com.farmacia.module.producto.adapter.in;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.farmacia.module.producto.application.AddProductoUseCase;
import com.farmacia.module.producto.application.DeleteProductoUseCase;
import com.farmacia.module.producto.application.FindProductoAllUseCase;
import com.farmacia.module.producto.application.FindProductoByIdUseCase;
import com.farmacia.module.producto.application.UpdateProductoUseCase;
import com.farmacia.module.producto.domain.entity.Producto;

public class ProductoConsoleAdapter {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final AddProductoUseCase productoAdd;
    private final FindProductoAllUseCase productoFindAll;
    private final FindProductoByIdUseCase findByCodigo;
    private final DeleteProductoUseCase productoDelete;
    private final UpdateProductoUseCase updateProducto;

    public ProductoConsoleAdapter(AddProductoUseCase productoAdd, FindProductoAllUseCase productoFindAll, FindProductoByIdUseCase findByCodigo, DeleteProductoUseCase productoDelete, UpdateProductoUseCase updateProducto) {
        this.productoAdd = productoAdd;
        this.productoFindAll = productoFindAll;
        this.findByCodigo = findByCodigo;
        this.productoDelete = productoDelete;
        this.updateProducto = updateProducto;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Listar todos productos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            switch (choice) {
                case 1:
                    System.out.print(">> Ingrese el código del producto: ");
                    String codigoProducto = scanner.nextLine();
                    System.out.print(">> Ingrese el nombre del producto: ");
                    String nombreProducto = scanner.nextLine();
                    System.out.print(">> Ingrese el registro Invima del producto: ");
                    String registroInvima = scanner.nextLine();
                    System.out.print(">> Ingrese el id de la vía de administración (número): ");
                    int viaAdministracion = scanner.nextInt();
                    System.out.print(">> Ingrese el id del principio activo (número): ");
                    int principioActivo = scanner.nextInt();
                    System.out.print(">> Ingrese el id de la unidad de medida (número): ");
                    int unidadMedida = scanner.nextInt();
                    System.out.print(">> Ingrese el id del laboratorio (número): ");
                    int laboratorio = scanner.nextInt();
                    System.out.print(">> Ingrese el id del proveedor (número): ");
                    int proveedor = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    System.out.print(">> Ingrese la presentación del producto: ");
                    String presentacion = scanner.nextLine();
                    System.out.print(">> Ingrese la fecha de caducidad del producto (dd/MM/yyyy): ");
                    String fechaCaducidadStr = scanner.nextLine();
                    Date fechaCaducidad = null;
                    
                    try {
                        fechaCaducidad = new Date(dateFormat.parse(fechaCaducidadStr).getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Formato de fecha inválido. Por favor, use el formato dd/MM/yyyy.");
                        break;
                    }
        
                    System.out.print(">> Ingrese el valor de compra del producto: ");
                    double valorCompra = scanner.nextDouble();
                    System.out.print(">> Ingrese el margen de ganancia del producto: ");
                    double margenGanancia = scanner.nextDouble();
                    System.out.print(">> Ingrese el stock del producto: ");
                    int stock = scanner.nextInt();
                    System.out.print(">> Ingrese el stock mínimo del producto: ");
                    int stockMin = scanner.nextInt();
                    System.out.print(">> Ingrese el stock máximo del producto: ");
                    int stockMax = scanner.nextInt();
                    
                    
                    // Crear el producto
                    Producto producto = new Producto(
                        codigoProducto, nombreProducto, registroInvima, viaAdministracion,
                        principioActivo, unidadMedida, laboratorio, proveedor,
                        presentacion, fechaCaducidad, valorCompra, margenGanancia,
                        stock, stockMin, stockMax
                    );                    
                    productoAdd.addProducto(producto);
                    break;

                case 2:
                    System.out.print(">> Ingrese el código del producto a actualizar: ");
                    String codigoUpdate = scanner.nextLine();
                    Optional<Producto> productoExistente = findByCodigo.execute(codigoUpdate);

                    if (!productoExistente.isPresent()) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    Producto productoActual = productoExistente.get();
                    
                    boolean actualizar = true;
                    while (actualizar) {
                        System.out.println("Seleccione el campo a actualizar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Registro Invima");
                        System.out.println("3. Valor de compra");
                        System.out.println("4. Margen de ganancia");
                        System.out.println("5. Stock");
                        System.out.println("6. Terminar actualización");
                        int campo = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea pendiente

                        switch (campo) {
                            case 1:
                                System.out.print(">> Ingrese el nuevo nombre: ");
                                productoActual.setNombreProducto(scanner.nextLine());
                                break;
                            case 2:
                                System.out.print(">> Ingrese el nuevo registro Invima: ");
                                productoActual.setRegistroInvima(scanner.nextLine());
                                break;
                            case 3:
                                System.out.print(">> Ingrese el nuevo valor de compra: ");
                                productoActual.setValorCompra(scanner.nextDouble());
                                scanner.nextLine(); // Consumir el salto de línea pendiente
                                break;
                            case 4:
                                System.out.print(">> Ingrese el nuevo margen de ganancia: ");
                                productoActual.setMargenGanancia(scanner.nextDouble());
                                scanner.nextLine(); // Consumir el salto de línea pendiente
                                break;
                            case 5:
                                System.out.print(">> Ingrese el nuevo stock: ");
                                productoActual.setStock(scanner.nextInt());
                                scanner.nextLine(); // Consumir el salto de línea pendiente
                                break;
                            case 6:
                                actualizar = false;
                                break;
                            default:
                                System.out.println("Opción inválida, intente de nuevo.");
                        }
                    }
                    updateProducto.execute(productoActual);
                    break;

                case 3:
                    System.out.print(">> Ingrese el código del producto: ");
                    String codigoBuscar = scanner.nextLine();
                    Optional<Producto> productoBuscado = findByCodigo.execute(codigoBuscar);
                    if (productoBuscado.isPresent()) {
                        Producto productoEncontrado = productoBuscado.get();
                        System.out.println("Código: " + productoEncontrado.getCodigoProducto() +
                                           " Nombre: " + productoEncontrado.getNombreProducto() +
                                           " Registro Invima: " + productoEncontrado.getRegistroInvima() +
                                           " Valor Compra: " + productoEncontrado.getValorCompra() +
                                           " Margen Ganancia: " + productoEncontrado.getMargenGanancia() +
                                           " Stock: " + productoEncontrado.getStock()+
                                           " Valor Venta: " + productoEncontrado.getValorVenta());
                                           
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print(">> Ingrese el código del producto: ");
                    String codigoDelete = scanner.nextLine();
                    productoDelete.execute(codigoDelete);
                    break;

                case 5:
                    List<Producto> listaProductos = productoFindAll.execute();
                    for (Producto prod : listaProductos) {
                        System.out.println("Código: " + prod.getCodigoProducto() +
                                           " Nombre: " + prod.getNombreProducto() +
                                           " Registro Invima: " + prod.getRegistroInvima() +
                                           " Valor Compra: " + prod.getValorCompra() +
                                           " Margen Ganancia: " + prod.getMargenGanancia() +
                                           " Stock: " + prod.getStock()+
                                           " Valor Venta: " + prod.getValorVenta());
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

