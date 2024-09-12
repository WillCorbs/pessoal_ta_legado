package com.api_vendinha.api.domain.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoRequestDto {

    /**
     * Nome do usuário.
     *
     * Este campo é obrigatório e será utilizado para criar ou atualizar um usuário no sistema.
     */
    private String nome;
    private Long qtde;
    private Double preco;
}
