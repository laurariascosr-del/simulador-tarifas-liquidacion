package simulador_tarifas.service;

import java.text.NumberFormat;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Contiene la lógica de negocio y los cálculos del simulador.
 */
@Service
public class LiquidacionService {

    @Value("${tarifas.valor-credito:85000}")
    private double valorCredito;

    @Value("${tarifas.cuota-administrativa:120000}")
    private double cuotaAdministrativa;

    @Value("${tarifas.porcentaje-descuento:10}")
    private double porcentajeDescuento;

    /**
     * Calcula una liquidación de ejemplo con base en la cantidad de créditos.
     *
     * @param cantidadCreditos número de créditos académicos
     * @return resumen de la liquidación
     */
    public String calcularLiquidacion(int cantidadCreditos) {
        if (cantidadCreditos <= 0) {
            throw new IllegalArgumentException("La cantidad de créditos debe ser mayor que cero.");
        }
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalStateException("El porcentaje de descuento debe estar entre 0 y 100.");
        }

        double subtotalCreditos = cantidadCreditos * valorCredito;
        double descuento = subtotalCreditos * (porcentajeDescuento / 100.0);
        double total = subtotalCreditos - descuento + cuotaAdministrativa;

        NumberFormat moneda = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
        return "SIMULADOR DE TARIFAS Y LIQUIDACIÓN INSTITUCIONAL\n"
                + "---------------------------------------------\n"
                + "Cantidad de créditos: " + cantidadCreditos + "\n"
                + "Valor por crédito: " + moneda.format(valorCredito) + "\n"
                + "Subtotal de créditos: " + moneda.format(subtotalCreditos) + "\n"
                + "Descuento (" + porcentajeDescuento + "%): -"
                + moneda.format(descuento) + "\n"
                + "Cuota administrativa: " + moneda.format(cuotaAdministrativa) + "\n"
                + "TOTAL A PAGAR: " + moneda.format(total) + "\n"
                + "---------------------------------------------";
    }
}
