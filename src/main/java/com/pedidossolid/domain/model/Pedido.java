package com.pedidossolid.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * Entidad de dominio del pedido. Solo contiene datos y reglas propias del pedido.
 */
public final class Pedido {

    private final UUID id;
    private final Cliente cliente;
    private final BigDecimal subtotal;
    private final BigDecimal descuento;
    private final BigDecimal total;

    public Pedido(UUID id, Cliente cliente, BigDecimal subtotal, BigDecimal descuento) {
        this.id = Objects.requireNonNull(id, "El id del pedido es obligatorio");
        this.cliente = Objects.requireNonNull(cliente, "El cliente es obligatorio");
        this.subtotal = validarMonto(subtotal, "El subtotal no puede ser negativo");
        this.descuento = validarMonto(descuento, "El descuento no puede ser negativo");

        if (this.descuento.compareTo(this.subtotal) > 0) {
            throw new IllegalArgumentException("El descuento no puede ser mayor que el subtotal");
        }

        this.total = this.subtotal.subtract(this.descuento);
    }

    public UUID id() {
        return id;
    }

    public Cliente cliente() {
        return cliente;
    }

    public BigDecimal subtotal() {
        return subtotal;
    }

    public BigDecimal descuento() {
        return descuento;
    }

    public BigDecimal total() {
        return total;
    }

    private static BigDecimal validarMonto(BigDecimal valor, String mensaje) {
        Objects.requireNonNull(valor, mensaje);
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }
}
