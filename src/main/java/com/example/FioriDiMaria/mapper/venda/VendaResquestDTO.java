package com.example.FioriDiMaria.mapper.venda;

import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualRequestDTO;
import com.example.FioriDiMaria.model.enums.StatusVenda;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record VendaResquestDTO(
        LocalDate data,
        StatusVenda status,
        List<VendaIndividualRequestDTO> vendasIndividuais
)
{}