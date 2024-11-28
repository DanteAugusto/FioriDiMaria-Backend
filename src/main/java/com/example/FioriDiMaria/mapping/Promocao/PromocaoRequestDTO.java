package com.example.FioriDiMaria.mapping.Promocao;

import java.time.LocalDate;

public record PromocaoRequestDTO(LocalDate dataInicio, LocalDate dataFim, Integer descontoPercentual, String nome) {

}