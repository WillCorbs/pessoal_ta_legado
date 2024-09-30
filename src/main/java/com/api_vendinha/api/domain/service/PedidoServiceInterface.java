package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.PedidoRequestDto;
import com.api_vendinha.api.domain.dtos.response.PedidoResponseDto;

public interface PedidoServiceInterface {
    PedidoResponseDto savePedido(PedidoRequestDto pedidoRequestDto);
}
