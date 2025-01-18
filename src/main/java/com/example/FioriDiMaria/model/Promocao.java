package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapper.Promocao.PromocaoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "promocoes")
@Entity(name = "promocoes")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Promocao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProduto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal descontoPercentual;
    private String nome;

    @OneToMany(mappedBy="promocao")
    private List<VendaIndividual> vendas = new ArrayList<>();

    @ManyToOne
    private Produto produto;

    public Promocao(PromocaoRequestDTO dto) {
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
        this.descontoPercentual = dto.descontoPercentual();
        this.nome = dto.nome();
    }
}
