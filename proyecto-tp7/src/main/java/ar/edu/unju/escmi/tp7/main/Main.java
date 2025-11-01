package ar.edu.unju.escmi.tp7.main;

import java.util.Collection;
import java.util.Scanner;

import ar.edu.unju.escmi.tp7.collections.CollectionCliente;
import ar.edu.unju.escmi.tp7.collections.CollectionProducto;
import ar.edu.unju.escmi.tp7.collections.CollectionStock;
import ar.edu.unju.escmi.tp7.collections.CollectionTarjetaCredito;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.collections.CollectionFactura;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		CollectionTarjetaCredito.precargarTarjetas();
        CollectionCliente.precargarClientes();
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStocks();
        int opcion = 0;
        do {
        	System.out.println("\n====== Menu Principal =====");
            System.out.println("1- Realizar una venta con programa Ahora 30");
            System.out.println("2- Revisar compras realizadas por el cliente (debe ingresar el DNI del cliente)");
            System.out.println("3- Mostrar lista de los electrodomésticos");
            System.out.println("4- Consultar stock");
            System.out.println("5- Revisar creditos de un cliente (debe ingresar el DNI del cliente)");
            System.out.println("6- Salir");

            System.out.println("Ingrese su opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    /*System.out.println("Ingrese DNI del cliente");
                    String dniInput = scanner.nextLine().trim();
                    long dni;

                    try {
                        dni = Long.parseLong(dniInput);
                    } catch (NumberFormatException e) {
                        System.out.println("DNI invalido. Por favor, ingrese un numero valido.");
                        break;
                    }

                    Cliente cliente = CollectionCliente.buscarCliente(dni);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado. Por favor, registre al cliente antes de realizar una venta.");
                        break;
                    }
                    
                    System.out.println("Cliente encontrado: " + cliente.getNombre());
                    System.out.println("Ingrese el codigo del producto a vender:");
                    String codigo = scanner.nextLine().trim();

                    if (codigo.isEmpty()) {
                        System.out.println("Codigo de producto invalido. Por favor, intente de nuevo.");
                        break;
                    }

                    Producto productoSeleccionado = null;
                    for (Producto producto : CollectionProducto.productos) {
                        if (producto.Codigo().equalsIgnoreCase(codigo)) {
                            productoSeleccionado = producto;
                            break;
                        }
                    }

                    if (productoSeleccionado == null) {
                        System.out.println("Producto no encontrado. Por favor, verifique el codigo e intente de nuevo.");
                        break;
                    }

                    System.out.println("Producto seleccionado: " + productoSeleccionado.getDescripcion());
                    System.out.println("Ingrese la cantidad que desea vender:");
                    int cantidad;

                    try {
                        cantidad = Integer.parseInt(scanner.nextLine().trim());
                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe ser mayor a cero.");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad invalida.");
                        break;
                    }

                    if (productoSeleccionado.getStock() < cantidad) {
                        System.out.println("Stock insuficiente para el producto seleccionado.");
                        break;
                    }
                    
                    Venta venta = new Venta(cliente, productoSeleccionado, cantidad);*/
                case 2:
                    System.out.println("Revisar compras realizadas por el cliente.");
                    System.out.println("Ingrese DNI del cliente:");
                    long dni = scanner.nextLong();
                    boolean encontrado = false;
                    for (var factura : CollectionFactura.consultarCompras(dni)) {
                        System.out.println(factura);
                        encontrado = true;
                    }
                    if (!encontrado) {
                        System.out.println("No se encontraron compras para el cliente con DNI: " + dni);
                    }

                    break;
                case 3:
                    System.out.println("====== Productos Disponibles ======");
                    for (var producto : CollectionProducto.productos) {
                        System.out.println(producto);
                    }
                    break;
                case 4:
                    System.out.println("Consultar stock de productos.");
                    for (var stock : CollectionStock.consultarStock()) {
                        System.out.println("Producto: " + stock.getProducto().getDescripcion() + " - Stock: " + stock.getCantidad());
                    }
                    break;
                case 5:
                    System.out.println("Revisar creditos de un cliente.");
                    System.out.println("Ingrese DNI del cliente:");
                    dni = scanner.nextLong();
                    boolean encontradoCredito = false;
                    for (var tarjeta : CollectionTarjetaCredito.tarjetas) {
                        if (tarjeta.getCliente().getDni() == dni) {
                            System.out.println(tarjeta);
                            encontradoCredito = true;
                        }
                    }
                    if (!encontradoCredito) {
                        System.out.println("No se encontraron creditos para el cliente con DNI: " + dni);
                    }
                    //CollectionCliente.revisarCreditosCliente();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, intente de nuevo.");
            }

        }while(opcion != 6);
        scanner.close();

	}

}
