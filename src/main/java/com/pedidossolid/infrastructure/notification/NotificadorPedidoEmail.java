package com.pedidossolid.infrastructure.notification;

import com.pedidossolid.domain.model.Pedido;
import com.pedidossolid.domain.notification.NotificadorPedido;

/**
 * Implementacion de notificacion por correo simulada en consola.
 */
public final class NotificadorPedidoEmail implements NotificadorPedido {

    @Override
    public void notificar(Pedido pedido) {
        System.out.printf(
                "Email enviado a %s: su pedido %s fue procesado por un total de $%s.%n",
                pedido.cliente().correoElectronico(),
                pedido.id(),
                pedido.total()
        );
    }
}
