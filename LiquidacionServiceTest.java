package simulador_tarifas.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LiquidacionServiceTest {

    @Test
    void rechazaUnaCantidadDeCreditosNoValida() {
        LiquidacionService service = new LiquidacionService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularLiquidacion(0));
    }
}
