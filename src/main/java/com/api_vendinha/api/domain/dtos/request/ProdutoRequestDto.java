package com.api_vendinha.api.domain.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class ProdutoRequestDto {
    private String nome;
    private Long qtde;
    private Double preco;
    private Boolean is_active;
    private List<PedidoRequestDto> pedidoRequestDtos;
}
