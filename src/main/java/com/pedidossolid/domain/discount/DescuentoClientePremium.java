package com.pedidossolid.domain.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Nueva politica agregada sin modificar ProcesarPedidoService. Demuestra OCP.
 */
public final class DescuentoClientePremium implements PoliticaDescuento {

    private static final BigDecimal PORCENTAJE = new BigDecimal("0.25");

    @Override
    public BigDecimal calcular(BigDecimal subtotal) {
        return subtotal.multiply(PORCENTAJE).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String descripcion() {
        return "Cliente premium - 25%";
    }
}
