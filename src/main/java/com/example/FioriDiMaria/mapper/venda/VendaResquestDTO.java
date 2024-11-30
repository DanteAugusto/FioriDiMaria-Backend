package com.example.FioriDiMaria.mapper.venda;

import com.example.FioriDiMaria.model.enums.StatusVenda;

import java.time.LocalDate;
import java.util.Date;

public record VendaResquestDTO(
        Long userId,
        LocalDate data,
        StatusVenda status
)
{}