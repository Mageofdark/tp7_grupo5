package ar.edu.unju.escmi.tp7.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp7.dominio.Credito;

public class CollectionCredito {
	public static List<Credito> creditos = new ArrayList<Credito>();
	public static void agregarCredito(Credito credito) {      
	   	try {
	   		creditos.add(credito);
		} catch (Exception e) {
			System.out.println("\nNO SE PUEDE GUARDAR EL CREDITO");
		}	
	}
	// Revisar los créditos de un cliente (ingresando el dni del cliente)
	public static List<Credito> consultarCreditos(long dni){
		List<Credito> creditosCliente = new ArrayList<Credito> ();
		if(CollectionCredito.creditos != null){
			for(Credito credito : CollectionCredito.creditos){
				if(credito.getTarjetaCredito().getCliente().getDni() == dni){
					creditosCliente.add(credito);					
				}
			}
		}else{	
			creditosCliente = null;
		}
		return creditosCliente;
	}
}
