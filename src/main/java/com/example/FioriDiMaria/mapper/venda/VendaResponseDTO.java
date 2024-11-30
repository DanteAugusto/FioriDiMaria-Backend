package com.example.FioriDiMaria.mapper.venda;

import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.model.enums.StatusVenda;

import java.sql.Date;
import java.time.LocalDate;

public record VendaResponseDTO(
    Long id,
    Long userId,
    LocalDate data,
    StatusVenda status
) {
    public VendaResponseDTO(Venda venda) {
        this(venda.getId(), venda.getUserId(), venda.getDate(), venda.getStatus());
    }
}