package com.example.FioriDiMaria.produto;

public record ProdutoResponseDTO(long id,String nome, double preco, String descricao, String foto) {
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getFoto());
    }
}

