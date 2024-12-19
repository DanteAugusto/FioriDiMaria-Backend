package com.example.FioriDiMaria.mapper.vendaIndividual;

import com.example.FioriDiMaria.model.Produto;
import com.example.FioriDiMaria.model.Promocao;
import com.example.FioriDiMaria.model.Venda;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public record VendaIndividualRequestDTO(
        int quantidade,
        BigDecimal precoUnitario,
        long idPromocao,
        long idProduto,
        long idVenda
) {
}