package com.pedidossolid.application.usecase;

import com.pedidossolid.domain.discount.PoliticaDescuento;
import com.pedidossolid.domain.model.Cliente;
import com.pedidossolid.domain.model.Pedido;

import java.math.BigDecimal;

/**
 * Puerto de entrada de la aplicacion. Define que puede hacer el caso de uso.
 */
public interface ProcesarPedidoUseCase {

    Pedido procesar(Cliente cliente, BigDecimal subtotal, PoliticaDescuento politicaDescuento);
}
