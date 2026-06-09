package com.pedidossolid.domain.discount;

import java.math.BigDecimal;

/**
 * Contrato pequeno y sustituible para calcular descuentos.
 */
public interface PoliticaDescuento {

    BigDecimal calcular(BigDecimal subtotal);

    String descripcion();
}
