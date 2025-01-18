package com.example.FioriDiMaria.mapper.Promocao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PromocaoRequestDTO(LocalDate dataInicio, LocalDate dataFim, BigDecimal descontoPercentual, String nome) {

}