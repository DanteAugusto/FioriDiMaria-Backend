package com.example.FioriDiMaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.repository.VendaRepository;

@Service
public class VendaService {
    
    @Autowired
    private VendaRepository vendaRepository;

    public Venda create(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda getById(Long id) {
        return vendaRepository.findById(id).orElse(null);
    }

    public List<Venda> getAll() {
        return vendaRepository.findAll();
    }

    public Venda update(Long id, Venda venda) {
        Venda vendaExistente = this.getById(id);

        vendaExistente.setData(venda.getData());

        return vendaRepository.save(vendaExistente);
    }

    public void delete(Long id) {
        vendaRepository.deleteById(id);
    }

    public void deleteAll() {
        vendaRepository.deleteAll();
    }

}
