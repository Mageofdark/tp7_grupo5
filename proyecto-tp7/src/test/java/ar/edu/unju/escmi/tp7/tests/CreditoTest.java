package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.*;

public class CreditoTest {

private Producto producto;
    private Detalle detalle;
    private List<Detalle> detalles;
    private Factura factura;
    private TarjetaCredito tarjeta;
    private Credito credito;

    @BeforeEach
    public void setUp() {
        producto = new Producto(1, "Heladera", 500000, "Argentina");
        detalle = new Detalle(2, 0, producto); // total = 1.000.000
        detalles = new ArrayList<>();
        detalles.add(detalle);
        factura = new Factura(LocalDate.now(), 100, null, detalles);
        tarjeta = new TarjetaCredito(123456789L, LocalDate.now().plusYears(2), null, 1200000);
        credito = new Credito(tarjeta, factura, new ArrayList<>());
    }

    @Test
    public void testMontoTotalCreditoNoSuperaLimite() {
        double montoTotal = factura.calcularTotal();
        assertTrue(montoTotal <= 1500000, "El monto total del crédito no debe superar los $1.500.000");
    }

    @Test
    public void testSumaDetallesIgualAlTotalFactura() {
        double sumaDetalles = 0;
        for (Detalle d : detalles) {
            sumaDetalles += d.getImporte();
        }
        assertEquals(sumaDetalles, factura.calcularTotal(),
                "La suma de los importes de los detalles debe coincidir con el total de la factura");
    }

    @Test
    public void testMontoTotalNoSuperaLimiteYTarjeta() {
        double total = factura.calcularTotal();
        assertTrue(total <= 1500000 && total <= tarjeta.getLimitCompra(),
                "El monto total no debe superar los $1.500.000 ni el límite de la tarjeta");
    }
}
