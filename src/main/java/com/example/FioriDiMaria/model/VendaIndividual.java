package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "venda_individual")
@Table(name = "venda_individual")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class VendaIndividual {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private Promocao promocao;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;

    public VendaIndividual (
            VendaIndividualRequestDTO dto,
            Promocao promocao,
            Produto produto,
            Venda venda) {
        this.quantidade = dto.quantidade();
        this.precoUnitario = dto.precoUnitario();
        this.promocao = promocao;
        this.produto = produto;
        this.venda = venda;
    }



    @Override
    public String toString() {
        return "{ id: " + this.id +
                ", quantidade: " + this.quantidade +
                ", precoUnitario: " + this.precoUnitario +
                ", id_promocao: " + (this.promocao == null ? "null" : this.promocao.getId()) +
                ", id_produto: " + this.produto.getId() +
                ", id_venda: " + this.venda.getId() +
                "}";
    }
}