package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Producto;
import ar.edu.unju.escmi.tp7.dominio.Stock;

public class StockTest {

    private Producto producto;
    private Stock stock;

    @BeforeEach
    public void setUp() {
        producto = new Producto(1, "Televisor", 200000, "Argentina");
        stock = new Stock(10, producto); // stock inicial es = 10
    }

    @Test
    public void testReducirStockTrasVenta() {
        int cantidadVendida = 3;
        stock.setCantidad(stock.getCantidad() - cantidadVendida);
        assertEquals(7, stock.getCantidad(), "El stock debe reducirse correctamente tras una venta");
    }
}
