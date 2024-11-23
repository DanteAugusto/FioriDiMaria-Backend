package com.example.FioriDiMaria.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoResponseDTO> findAll() {
        return produtoRepository.findAll().stream().map(ProdutoResponseDTO::new).toList();
    }
    public ProdutoResponseDTO findById(Long id) {
        return produtoRepository.findById(id).map(ProdutoResponseDTO::new).orElse(null);
    }

    public void saveNew(ProdutoRequestDTO dto) {
        Produto produto = new Produto(dto);
        produtoRepository.save(produto);
    }

    public boolean update(long id, ProdutoRequestDTO dto) {
        Optional<Produto> tryProduto = produtoRepository.findById(id);
        if (tryProduto.isEmpty()) return false;

        Produto produto = tryProduto.get();

        produto.setNome(dto.nome());
        produto.setPreco(dto.preco());
        produto.setDescricao(dto.descricao());
        produto.setFoto(dto.foto());
        produtoRepository.save(produto);
        return true;
    }

    public boolean delete(long id) {
        Optional<Produto> tryProduto = produtoRepository.findById(id);
        if (tryProduto.isEmpty()) return false;
        produtoRepository.delete(tryProduto.get());
        return true;
    }


}
