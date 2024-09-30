package com.api_vendinha.api.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "qtde")
    private Long qtde;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "is_active")
    private Boolean is_active;

    @OneToMany(mappedBy = "produto")
    private List<Pedido> pedidos;
}
