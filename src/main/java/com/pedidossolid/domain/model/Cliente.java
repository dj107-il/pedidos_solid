package com.pedidossolid.domain.model;

import java.util.Objects;

/**
 * Entidad de dominio que representa al cliente que realiza un pedido.
 */
public final class Cliente {

    private final String nombre;
    private final String correoElectronico;

    public Cliente(String nombre, String correoElectronico) {
        this.nombre = validarTexto(nombre, "El nombre del cliente es obligatorio");
        this.correoElectronico = validarTexto(correoElectronico, "El correo electronico es obligatorio");
    }

    public String nombre() {
        return nombre;
    }

    public String correoElectronico() {
        return correoElectronico;
    }

    private static String validarTexto(String valor, String mensaje) {
        if (Objects.isNull(valor) || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor.trim();
    }
}
