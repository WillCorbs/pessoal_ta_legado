package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.Infrastructure.repository.PedidoRepository;
import com.api_vendinha.api.domain.dtos.request.PedidoRequestDto;
import com.api_vendinha.api.domain.dtos.response.PedidoResponseDto;
import com.api_vendinha.api.domain.entities.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoServiceInterface {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) { this.pedidoRepository = pedidoRepository; }

    @Override
    public PedidoResponseDto savePedido(PedidoRequestDto pedidoRequestDto) {
        Pedido pedido = new Pedido();

        pedido.setQtde(pedidoRequestDto.getQtde());
        pedido.setPreco(pedidoRequestDto.getPreco());

        Pedido savedPedido = pedidoRepository.save(pedido);

        return getPedidoResponse(savedPedido);
    }

    private PedidoResponseDto getPedidoResponse(Pedido pedido) {
        PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();

        pedidoResponseDto.setId(pedido.getId());
        pedidoResponseDto.setQtde(pedido.getQtde());
        pedidoResponseDto.setPreco(pedido.getPreco());

        return pedidoResponseDto;
    }
}
