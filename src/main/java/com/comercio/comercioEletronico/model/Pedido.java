package com.comercio.comercioEletronico.model;

import com.comercio.comercioEletronico.model.enuns.StatusEnvio;
import com.comercio.comercioEletronico.model.enuns.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "pedidos_produtos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;
    @NotNull
    private List<Integer> quantidadeItensPedidos;
    @Embedded
    private Endereco enderecoEntrega;

    private StatusPagamento statusPagamento;

    private StatusEnvio statusEnvio;
    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dataPedido;
    @NotNull
    private Double valorTotal;
}
