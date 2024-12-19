package com.example.FioriDiMaria.controller;

import com.example.FioriDiMaria.mapper.vendaIndividual.VendaIndividualResponseDTO;
import com.example.FioriDiMaria.model.VendaIndividual;
import com.example.FioriDiMaria.service.VendaIndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teste/vendaIndividual")
public class TesteVendaIndividualController {
    @Autowired
    private VendaIndividualService vendaIndividualService;

    @GetMapping
    public List<VendaIndividualResponseDTO> getAll() {
        return vendaIndividualService.findAll();
    }
}
