package com.api_vendinha.api.domain.dtos.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String cpf_cnpj;
    private Boolean is_active;
    private List<PedidoRequestDto> pedidoRequestDtos;
}
