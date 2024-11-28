package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapping.Promocao.PromocaoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private Integer descontoPercentual;
    private String nome;

    public Promocao(PromocaoRequestDTO dto) {
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
        this.descontoPercentual = dto.descontoPercentual();
        this.nome = dto.nome();
    }
}
