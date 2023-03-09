package com.comercio.comercioEletronico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "pedidos"})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "nome", length = 255)
    private String nome;
    @NotBlank
    @Column(name = "marca", length = 255)
    private String marca;
    @NotBlank
    @Column(name = "modelo", length = 255)
    private String modelo;
    @NotBlank
    @Column(name = "descricao", length = 255)
    private String descricao;
    @NotNull
    @Column(name = "preco")
    private Double preco;
    @NotNull
    @Column(name = "quantidade_estoque", length = 255)
    private Integer quantidadeEstoque;
    @Column(name = "imagem", length = 255)
    private String imagem;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToMany(mappedBy = "produtos")
    private List<Pedido> pedidos;

}
