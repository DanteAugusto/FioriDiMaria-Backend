package com.example.FioriDiMaria.mapper.venda;

import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualResponseDTO;
import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.model.enums.StatusVenda;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public record VendaResponseDTO(
    Long id,
    LocalDate data,
    StatusVenda status,
    List<VendaIndividualResponseDTO> vendasIndividuais
) {
    public VendaResponseDTO(Venda venda, List<VendaIndividualResponseDTO> vendasIndividuais) {
        this(venda.getId(), venda.getDate(), venda.getStatus(), vendasIndividuais);
    }
}