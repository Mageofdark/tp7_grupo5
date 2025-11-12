package ar.edu.unju.escmi.tp7.main;

import java.util.Scanner;


import ar.edu.unju.escmi.tp7.collections.CollectionCliente;
import ar.edu.unju.escmi.tp7.collections.CollectionProducto;
import ar.edu.unju.escmi.tp7.collections.CollectionStock;
import ar.edu.unju.escmi.tp7.collections.CollectionTarjetaCredito;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.collections.CollectionFactura;
import ar.edu.unju.escmi.tp7.dominio.Cliente;
import ar.edu.unju.escmi.tp7.dominio.Detalle;


public class Main {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		CollectionTarjetaCredito.precargarTarjetas();
        CollectionCliente.precargarClientes();
        CollectionProducto.precargarProductos();
        CollectionStock.precargarStocks();
       Scanner scanner = new Scanner(System.in);
int opcion = 0;

do {
    System.out.println("===== Menu Principal ====");
    System.out.println("1- Realizar una venta con programa Ahora 30");
    System.out.println("2- Revisar compras realizadas por el cliente");
    System.out.println("3- Mostrar lista de los electrodomésticos");
    System.out.println("4- Consultar stock");
    System.out.println("5- Revisar créditos de un cliente");
    System.out.println("6- Salir");
    System.out.print("Ingrese su opción: ");

    String inputOpcion = scanner.nextLine().trim();
    if (inputOpcion.isEmpty()) {
        System.out.println("✘ No ingresó ninguna opción.");
        continue;
    }

    try {
        opcion = Integer.parseInt(inputOpcion);
    } catch (NumberFormatException e) {
        System.out.println("✘ Opción inválida. Debe ser numérica.");
        continue;
    }

    switch (opcion) {
        case 1: {
            System.out.println("Realizar una venta con programa Ahora 30");
            System.out.print("Ingrese DNI del cliente: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("✘ No ingresó ningún valor.");
                break;
            }

            long dni;
            try {
                dni = Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("✘ DNI inválido. Debe ser numérico.");
                break;
            }

            Cliente cliente = CollectionCliente.buscarCliente(dni);
            if (cliente == null) {
                System.out.println("✘ Cliente no encontrado. Regístrelo primero.");
                break;
            }

            System.out.print("Ingrese código del producto: ");
            String inputCodigo = scanner.nextLine().trim();
            long codigo;
            try {
                codigo = Long.parseLong(inputCodigo);
            } catch (NumberFormatException e) {
                System.out.println("❌ Código inválido.");
                break;
            }

            Producto producto = CollectionProducto.buscarProducto(codigo);
            if (producto == null) {
                System.out.println("❌ Producto no encontrado.");
                break;
            }

            System.out.print("Ingrese cantidad a comprar: ");
            String inputCantidad = scanner.nextLine().trim();
            int cantidad;
            try {
                cantidad = Integer.parseInt(inputCantidad);
                if (cantidad <= 0) {
                    System.out.println("❌ La cantidad debe ser mayor a cero.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Cantidad inválida.");
                break;
            }

            if (producto.getStock() < cantidad) {
                System.out.println("❌ Stock insuficiente. Disponible: " + producto.getStock());
                break;
            }

            CollectionStock.reducirStock(CollectionStock.buscarStock(producto), cantidad);

            Factura factura = new Factura();
            factura.setCliente(cliente);
            factura.setFecha(java.time.LocalDate.now());

            Detalle detalle = new Detalle();
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setImporte(cantidad * producto.getPrecioUnitario());

            factura.getDetalles().add(detalle);
            factura.calcularTotal();

            CollectionFactura.agregarFactura(factura);

            System.out.println("✅ Venta realizada con éxito.");
            System.out.println("Factura generada:");
            System.out.println(factura);
            break;
        }

        case 2: {
            System.out.println("Revisar compras realizadas por el cliente.");
            System.out.print("Ingrese DNI del cliente: ");
            String input = scanner.nextLine().trim();
            long dni;
            try {
                dni = Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("✘ DNI inválido.");
                break;
            }

            boolean encontrado = false;
            for (var fact : CollectionFactura.consultarCompras(dni)) {
                System.out.println(fact);
                encontrado = true;
            }
            if (!encontrado) {
                System.out.println("No se encontraron compras para el cliente con DNI: " + dni);
            }
            break;
        }

        case 3:
            System.out.println("====== Productos Disponibles ======");
            for (var prod : CollectionProducto.productos) {
                System.out.println(prod);
            }
            break;

        case 4:
            System.out.println("Consultar stock de productos.");
            for (var stock : CollectionStock.consultarStock()) {
                System.out.println("Producto: " + stock.getProducto().getDescripcion() + " - Stock: " + stock.getCantidad());
            }
            break;

        case 5: {
            System.out.println("Revisar créditos de un cliente.");
            System.out.print("Ingrese DNI del cliente: ");
            String input = scanner.nextLine().trim();
            long dni;
            try {
                dni = Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("✘ DNI inválido.");
                break;
            }

            boolean encontradoCredito = false;
            for (var tarjeta : CollectionTarjetaCredito.tarjetas) {
                Cliente cliente = tarjeta.getCliente();
                if (cliente != null && cliente.getDni() == dni) {
                    System.out.println(tarjeta);
                    encontradoCredito = true;
                }
            }
            if (!encontradoCredito) {
                System.out.println("No se encontraron créditos para el cliente con DNI: " + dni);
            }
            break;
        }

        case 6:
            System.out.println("Saliendo del programa...");
            break;

        default:
            System.out.println("Opción inválida. Por favor, intente de nuevo.");
            break;
        }

            } while (opcion != 6);

        scanner.close();

	}

}
