package com.pedidossolid;

import com.pedidossolid.application.service.ProcesarPedidoService;
import com.pedidossolid.application.usecase.ProcesarPedidoUseCase;
import com.pedidossolid.domain.discount.DescuentoClientePremium;
import com.pedidossolid.domain.discount.DescuentoClienteRegular;
import com.pedidossolid.domain.discount.DescuentoClienteVip;
import com.pedidossolid.domain.discount.PoliticaDescuento;
import com.pedidossolid.domain.model.Cliente;
import com.pedidossolid.domain.model.Pedido;
import com.pedidossolid.domain.notification.NotificadorPedido;
import com.pedidossolid.domain.repository.PedidosRepository;
import com.pedidossolid.infrastructure.notification.NotificadorPedidoEmail;
import com.pedidossolid.infrastructure.repository.PedidosRepositoryEnMemoria;

import java.math.BigDecimal;

/**
 * Punto de entrada para probar el caso de uso con distintas politicas.
 */
public final class Main {

    public static void main(String[] args) {
        PedidosRepository pedidosRepository = new PedidosRepositoryEnMemoria();
        NotificadorPedido notificadorPedido = new NotificadorPedidoEmail();
        ProcesarPedidoUseCase procesarPedidoUseCase =
                new ProcesarPedidoService(pedidosRepository, notificadorPedido);

        procesarEscenario(
                procesarPedidoUseCase,
                new Cliente("Ana Regular", "ana.regular@correo.com"),
                new BigDecimal("100000"),
                new DescuentoClienteRegular()
        );

        procesarEscenario(
                procesarPedidoUseCase,
                new Cliente("Carlos VIP", "carlos.vip@correo.com"),
                new BigDecimal("200000"),
                new DescuentoClienteVip()
        );

        procesarEscenario(
                procesarPedidoUseCase,
                new Cliente("Laura Premium", "laura.premium@correo.com"),
                new BigDecimal("300000"),
                new DescuentoClientePremium()
        );
    }

    private static void procesarEscenario(
            ProcesarPedidoUseCase useCase,
            Cliente cliente,
            BigDecimal subtotal,
            PoliticaDescuento politicaDescuento
    ) {
        System.out.printf("%nProcesando pedido para %s (%s)%n", cliente.nombre(), politicaDescuento.descripcion());

        Pedido pedido = useCase.procesar(cliente, subtotal, politicaDescuento);

        System.out.printf("Subtotal: $%s%n", pedido.subtotal());
        System.out.printf("Descuento: $%s%n", pedido.descuento());
        System.out.printf("Total: $%s%n", pedido.total());
    }
}
