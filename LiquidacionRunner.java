package simulador_tarifas.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import simulador_tarifas.service.LiquidacionService;

/**
 * Ejecuta una liquidación automáticamente cuando inicia Spring Boot.
 */
@Component
public class LiquidacionRunner implements CommandLineRunner {

    private final LiquidacionService liquidacionService;

    /**
     * Spring inyecta el servicio; no se utiliza new LiquidacionService().
     */
    @Autowired
    public LiquidacionRunner(LiquidacionService liquidacionService) {
        this.liquidacionService = liquidacionService;
    }

    @Override
    public void run(String... args) {
        System.out.println();
        System.out.println(liquidacionService.calcularLiquidacion(12));
        System.out.println();
        System.out.println("La aplicación inició correctamente y ejecutó la liquidación.");
    }
}
