package com.pedidossolid.domain.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Politica para clientes regulares: 5% de descuento.
 */
public final class DescuentoClienteRegular implements PoliticaDescuento {

    private static final BigDecimal PORCENTAJE = new BigDecimal("0.05");

    @Override
    public BigDecimal calcular(BigDecimal subtotal) {
        return subtotal.multiply(PORCENTAJE).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String descripcion() {
        return "Cliente regular - 5%";
    }
}
