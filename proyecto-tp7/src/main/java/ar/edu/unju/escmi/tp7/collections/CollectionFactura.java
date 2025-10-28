package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Factura;

public class CollectionFactura {

	public static List<Factura> facturas = new ArrayList<Factura>();

	

	public static void agregarFactura(Factura factura) {
		
		try {
			facturas.add(factura);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR LA FACTURA");
		}
		
	}


	public static Factura buscarFactura(long nroFactura) {
		Factura facturaEncontrada = null;
		
		try {
			if (facturas != null) {
				for (Factura fac : facturas) {
					if (fac.getNroFactura() == nroFactura) {
						facturaEncontrada = fac;
					}
				}
			}
		} catch (Exception e) {
			return null;
		}
		
		return facturaEncontrada;
	}

	
	// Ver Compras realizadas por el cliente (ingresando el dni del cliente).
	public static List<Factura> consultarCompras(long dni) {
		List<Factura> shoppingList = new ArrayList<Factura>();
		if (CollectionFactura.facturas != null) {
			for (Factura fac : CollectionFactura.facturas) {
				if (fac.getCliente().getDni() == dni) {
					shoppingList.add(fac);
				}
			}
		} else {
			shoppingList = null;
		}
		return shoppingList;
	}
}
