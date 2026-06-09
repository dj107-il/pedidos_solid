package com.pedidossolid.domain.repository;

import com.pedidossolid.domain.model.Pedido;

/**
 * Puerto de salida para persistir pedidos, sin acoplar el dominio a una base de datos concreta.
 */
public interface PedidosRepository {

    void guardar(Pedido pedido);
}
