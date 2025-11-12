package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unju.escmi.tp7.dominio.Credito;
import ar.edu.unju.escmi.tp7.dominio.Cuota;
import ar.edu.unju.escmi.tp7.dominio.Factura;
import ar.edu.unju.escmi.tp7.dominio.TarjetaCredito;

public class CuotaTest {

    private Credito credito;
    private List<Cuota> cuotasGeneradas;

    @BeforeEach
    public void setUp() {
        // Crea objetos minimos nesesarios para que el generarCuotas() funcione
        TarjetaCredito tarjeta = new TarjetaCredito(); // no importa el contenido, solo evitar null
        Factura factura = new Factura() {
            @Override
            public double calcularTotal() {
                return 30000; // esto simula una factura con el total 30000
            }
        };

        credito = new Credito(tarjeta, factura, new ArrayList<>());
        cuotasGeneradas = credito.getCuotas();
    }

    @Test
    public void testGenerarCuotasNoDevuelveNull() {
        assertNotNull(cuotasGeneradas, "El método generarCuotas no debe devolver una lista null");
    }

    @Test
    public void testGenerarCuotasCrea30Cuotas() {
        assertEquals(30, cuotasGeneradas.size(), "Debe generar exactamente 30 cuotas");
    }

    @Test
    public void testMontoDeCadaCuotaEsCorrecto() {
        assertEquals(1000, cuotasGeneradas.get(0).getMonto(), 0.001,
                "Cada cuota debe tener el monto correcto total/30");
    }

    @Test
    public void testCuotasTienenFechasDeVencimientoCorrectas() {
        assertTrue(cuotasGeneradas.get(1).getFechaVencimiento()
                .isAfter(cuotasGeneradas.get(0).getFechaVencimiento()), 
                "Las fechas de vencimiento deben ser crecientes mes a mes");
    }
}
