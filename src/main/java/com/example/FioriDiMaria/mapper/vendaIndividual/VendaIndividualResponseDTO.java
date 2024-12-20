package com.example.FioriDiMaria.mapper.vendaIndividual;

import com.example.FioriDiMaria.model.Promocao;
import com.example.FioriDiMaria.model.VendaIndividual;

import java.math.BigDecimal;
import java.util.Optional;

public record VendaIndividualResponseDTO(
        long id,
        int quantidade,
        BigDecimal precoUnitario,
        Optional<Long> idPromocao,
        long idProduto,
        long idVenda
) {
    public VendaIndividualResponseDTO(VendaIndividual vendaIndividual) {
        this(
                vendaIndividual.getId(),
                vendaIndividual.getQuantidade(),
                vendaIndividual.getPrecoUnitario(),
                Optional.ofNullable(vendaIndividual.getPromocao()).map(Promocao::getId),
                vendaIndividual.getProduto().getId(),
                vendaIndividual.getVenda().getId()
                );
    }

}