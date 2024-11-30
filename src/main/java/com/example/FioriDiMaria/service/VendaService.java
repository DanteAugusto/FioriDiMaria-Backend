package com.example.FioriDiMaria.service;

import java.util.List;
import java.util.Optional;

import com.example.FioriDiMaria.mapper.venda.VendaResponseDTO;
import com.example.FioriDiMaria.mapper.venda.VendaResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    public VendaResponseDTO create(VendaResquestDTO dto) {
        Venda newVenda = new Venda(dto);
        vendaRepository.save(newVenda);
        return new VendaResponseDTO(newVenda);
    }

    public VendaResponseDTO getById(Long id) {
        return vendaRepository.findById(id).map(VendaResponseDTO::new).orElse(null);
    }

    public List<VendaResponseDTO> getAll() {
        return vendaRepository.findAll().stream().map(VendaResponseDTO::new).toList();
    }

    public VendaResponseDTO update(Long id, VendaResquestDTO dto) {
        Optional<Venda> tryVenda = vendaRepository.findById(id);
        if(tryVenda.isEmpty()){
            return null;
        }
        Venda venda = tryVenda.get();

        venda.setUserId(dto.userId());
        venda.setDate(dto.data());
        venda.setStatus(dto.status());
        vendaRepository.save(venda);
        return new VendaResponseDTO(venda);
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
