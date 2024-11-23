package com.example.FioriDiMaria.Promocao;

import java.time.LocalDate;

public record PromocaoResponseDTO(Long id, Long idProduto, LocalDate dataInicio, LocalDate dataFim, Integer descontoPercentual, String nome) {

    public PromocaoResponseDTO(Promocao promocao){
        this(promocao.getId(), promocao.getIdProduto(), promocao.getDataInicio(), promocao.getDataFim(), promocao.getDescontoPercentual(), promocao.getNome());
    }
}
