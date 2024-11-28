package com.example.FioriDiMaria.mapper.produto;

import com.example.FioriDiMaria.model.Produto;

public record ProdutoResponseDTO(long id, String nome, double preco, String descricao, String foto) {
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getFoto());
    }
}

