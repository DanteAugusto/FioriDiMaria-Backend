package com.example.FioriDiMaria.model;

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
    private String descricao;

    @ManyToOne
    private Promocao promocao;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Venda venda;
}

//@OneToMany(mappedBy="usuario")
//    private List<Venda> vendas = new ArrayList<>();


//@Entity(name = "vendas")
//@Table(name = "vendas")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//public class Venda {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Long userId;
//    private LocalDate date;
//    private StatusVenda status;
//
//    @ManyToOne
//    private Usuario usuario;
//
//    public Venda(VendaResquestDTO dto) {
//        this.userId = dto.userId();
//        this.date = dto.data();
//        this.status = dto.status();
//    }
//}