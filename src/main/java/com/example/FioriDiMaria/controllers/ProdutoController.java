package com.example.FioriDiMaria.controllers;

import com.example.FioriDiMaria.produto.ProdutoRequestDTO;
import com.example.FioriDiMaria.produto.ProdutoResponseDTO;
import com.example.FioriDiMaria.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponseDTO> getAll() {
        return produtoService.findAll();
    }

    @PostMapping
    public void newProduct(@RequestBody ProdutoRequestDTO produto) {
        produtoService.saveNew(produto);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProdutoRequestDTO produto) {
        produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        produtoService.delete(id);
    }
}
