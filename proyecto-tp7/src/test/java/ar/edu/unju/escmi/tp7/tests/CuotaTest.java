package ar.edu.unju.escmi.tp7.tests;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unju.escmi.tp7.dominio.Cuota;

public class CuotaTest {

    private List<Cuota> cuotas;

    @BeforeEach
    public void setUp() {
        cuotas = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            cuotas.add(new Cuota(1000, i, LocalDate.now(), LocalDate.now().plusMonths(i)));
        }
    }

    @Test
    public void testListaCuotasNoEsNull() {
        assertNotNull(cuotas, "La lista de cuotas no debe ser null");
    }

    @Test
    public void testListaCuotasTiene30Elementos() {
        assertEquals(30, cuotas.size(), "La lista de cuotas debe tener exactamente 30 elementos");
    }

    @Test
    public void testNoSeGeneranMasDe30Cuotas() {
        assertTrue(cuotas.size() <= 30, "No deben generar más de 30 cuotas");
    }
}
