package com.example.FioriDiMaria.mapper.Promocao;

import com.example.FioriDiMaria.model.Promocao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PromocaoResponseDTO(Long id, Long idProduto, LocalDate dataInicio, LocalDate dataFim, BigDecimal descontoPercentual, String nome) {

    public PromocaoResponseDTO(Promocao promocao){
        this(promocao.getId(), promocao.getIdProduto(), promocao.getDataInicio(), promocao.getDataFim(), promocao.getDescontoPercentual(), promocao.getNome());
    }
}
