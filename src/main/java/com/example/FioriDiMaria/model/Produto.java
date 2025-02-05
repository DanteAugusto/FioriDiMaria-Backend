package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapper.produto.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "produtos")
@Entity(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private double preco;
    private String descricao;
    private String foto;

    @ManyToMany(mappedBy = "produtos")
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy="produto")
    private List<VendaIndividual> vendas = new ArrayList<>();

    @OneToMany(mappedBy="produto")
    private List<Promocao> promocoes = new ArrayList<>();

    public Produto(ProdutoRequestDTO produtoRequestDTO) {
        this.nome = produtoRequestDTO.nome();;
        this.preco = produtoRequestDTO.preco();
        this.descricao = produtoRequestDTO.descricao();
        this.foto = produtoRequestDTO.foto();
    }

}
