package com.pedidossolid.application.service;

import com.pedidossolid.application.usecase.ProcesarPedidoUseCase;
import com.pedidossolid.domain.discount.PoliticaDescuento;
import com.pedidossolid.domain.model.Cliente;
import com.pedidossolid.domain.model.Pedido;
import com.pedidossolid.domain.notification.NotificadorPedido;
import com.pedidossolid.domain.repository.PedidosRepository;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * Orquesta el caso de uso de procesamiento de pedidos.
 * Depende de abstracciones y no conoce implementaciones concretas.
 */
public final class ProcesarPedidoService implements ProcesarPedidoUseCase {

    private final PedidosRepository pedidosRepository;
    private final NotificadorPedido notificadorPedido;

    public ProcesarPedidoService(PedidosRepository pedidosRepository, NotificadorPedido notificadorPedido) {
        this.pedidosRepository = Objects.requireNonNull(pedidosRepository, "El repositorio es obligatorio");
        this.notificadorPedido = Objects.requireNonNull(notificadorPedido, "El notificador es obligatorio");
    }

    @Override
    public Pedido procesar(Cliente cliente, BigDecimal subtotal, PoliticaDescuento politicaDescuento) {
        Objects.requireNonNull(cliente, "El cliente es obligatorio");
        Objects.requireNonNull(subtotal, "El subtotal es obligatorio");
        Objects.requireNonNull(politicaDescuento, "La politica de descuento es obligatoria");

        BigDecimal descuento = politicaDescuento.calcular(subtotal);
        Pedido pedido = new Pedido(UUID.randomUUID(), cliente, subtotal, descuento);

        pedidosRepository.guardar(pedido);
        notificadorPedido.notificar(pedido);

        return pedido;
    }
}
