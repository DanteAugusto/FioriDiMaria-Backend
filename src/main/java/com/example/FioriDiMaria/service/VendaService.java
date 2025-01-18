package com.example.FioriDiMaria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.FioriDiMaria.mapper.venda.VendaResponseDTO;
import com.example.FioriDiMaria.mapper.venda.VendaResquestDTO;
import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualRequestDTO;
import com.example.FioriDiMaria.model.Endereco;
import com.example.FioriDiMaria.model.VendaIndividual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private VendaIndividualService vendaIndividualService;

    public VendaResponseDTO create(VendaResquestDTO dto, long idEndereco) {
        Endereco endereco = enderecoService.getEndereco(idEndereco);
        if (endereco == null) return null;
        Venda newVenda = new Venda(dto, endereco);
        List<VendaIndividual> vendasIndividuais = dto.vendasIndividuais().stream()
                .map(vi -> vendaIndividualService.makeNew(vi, newVenda)).toList();
        if(vendasIndividuais.stream().anyMatch(Objects::isNull)){
            return null;
        }
        newVenda.setVendas(vendasIndividuais);
        vendaRepository.save(newVenda);

        return new VendaResponseDTO(newVenda, vendaIndividualService.findFromVenda(newVenda.getId()));
    }

    public VendaResponseDTO getById(Long id) {
//        return vendaRepository.findById(id).map(VendaResponseDTO::new).orElse(null);
        Venda venda = vendaRepository.findById(id).orElse(null);
        if (venda == null) return null;
        return new VendaResponseDTO(venda, vendaIndividualService.findFromVenda(id));
    }

    public List<VendaResponseDTO> getAll() {
        return vendaRepository.findAll().stream().map(
                venda -> new VendaResponseDTO(venda, vendaIndividualService.findFromVenda(venda.getId()))
        ).toList();
    }

    public VendaResponseDTO update(Long id, VendaResquestDTO dto) {
        Optional<Venda> tryVenda = vendaRepository.findById(id);
        if(tryVenda.isEmpty()){
            return null;
        }
        Venda venda = tryVenda.get();

        venda.setDate(dto.data());
        venda.setStatus(dto.status());
        vendaRepository.save(venda);
        return new VendaResponseDTO(venda, vendaIndividualService.findFromVenda(venda.getId()));
    }

    public boolean delete(Long id) {
        Optional<Venda> tryVenda = vendaRepository.findById(id);
        if(tryVenda.isEmpty()) return false;
        vendaRepository.delete(tryVenda.get());
        return true;
    }

    public void deleteAll() {
        vendaRepository.deleteAll();
    }

}
