package com.example.FioriDiMaria.service;

import com.example.FioriDiMaria.mapper.produto.ProdutoRequestDTO;
import com.example.FioriDiMaria.mapper.produto.ProdutoResponseDTO;
import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualRequestDTO;
import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualResponseDTO;
import com.example.FioriDiMaria.model.Produto;
import com.example.FioriDiMaria.model.Promocao;
import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.model.VendaIndividual;
import com.example.FioriDiMaria.repository.ProdutoRepository;
import com.example.FioriDiMaria.repository.PromocaoRepository;
import com.example.FioriDiMaria.repository.VendaIndividualRepository;
import com.example.FioriDiMaria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaIndividualService {
    @Autowired
    private VendaIndividualRepository vendaIndividualRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PromocaoRepository promocaoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public List<VendaIndividualResponseDTO> findAll() {
        return vendaIndividualRepository.findAll().stream().map(VendaIndividualResponseDTO::new).toList();
    }

    public VendaIndividualResponseDTO findById(Long id) {
        return vendaIndividualRepository.findById(id).map(VendaIndividualResponseDTO::new).orElse(null);
    }

    public VendaIndividual makeNew(VendaIndividualRequestDTO dto, Venda venda) {
        Produto produto = produtoRepository.findById(dto.idProduto()).orElse(null);
        if (produto == null) return null;
        Promocao promocao = promocaoRepository.findById(dto.idPromocao()).orElse(null);

        return new VendaIndividual(dto, promocao, produto, venda);
    }

    public List<VendaIndividualResponseDTO> findFromVenda(Long idVenda) {
        return vendaIndividualRepository.findByVendaId(idVenda).stream().map(VendaIndividualResponseDTO::new).toList();
    }

//
//    public boolean update(long id, ProdutoRequestDTO dto) {
//        Optional<Produto> tryProduto = produtoRepository.findById(id);
//        if (tryProduto.isEmpty()) return false;
//
//        Produto produto = tryProduto.get();
//
//        produto.setNome(dto.nome());
//        produto.setPreco(dto.preco());
//        produto.setDescricao(dto.descricao());
//        produto.setFoto(dto.foto());
//        produtoRepository.save(produto);
//        return true;
//    }
//
//    public boolean delete(long id) {
//        Optional<Produto> tryProduto = produtoRepository.findById(id);
//        if (tryProduto.isEmpty()) return false;
//        produtoRepository.delete(tryProduto.get());
//        return true;
//    }
}
