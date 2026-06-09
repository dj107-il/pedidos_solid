package com.pedidossolid.domain.notification;

import com.pedidossolid.domain.model.Pedido;

/**
 * Puerto de salida para enviar notificaciones relacionadas con pedidos.
 */
public interface NotificadorPedido {

    void notificar(Pedido pedido);
}
