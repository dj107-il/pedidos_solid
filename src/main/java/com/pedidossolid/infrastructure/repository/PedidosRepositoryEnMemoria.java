package com.pedidossolid.infrastructure.repository;

import com.pedidossolid.domain.model.Pedido;
import com.pedidossolid.domain.repository.PedidosRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementacion simple en memoria para pruebas academicas y ejecucion local.
 */
public final class PedidosRepositoryEnMemoria implements PedidosRepository {

    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
        System.out.printf("Repositorio: pedido %s guardado.%n", pedido.id());
    }

    public List<Pedido> listar() {
        return Collections.unmodifiableList(pedidos);
    }
}
