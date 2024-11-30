package com.example.FioriDiMaria.model;

import java.time.LocalDate;
import java.util.Date;

import com.example.FioriDiMaria.mapper.venda.VendaResquestDTO;
import com.example.FioriDiMaria.model.enums.StatusVenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.DateTimeUtils;

@Entity(name = "vendas")
@Table(name = "vendas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private LocalDate date;
    private StatusVenda status;

    @ManyToOne
    private Usuario usuario;

    public Venda(VendaResquestDTO dto) {
        this.userId = dto.userId();
        this.date = dto.data();
        this.status = dto.status();
    }
}
