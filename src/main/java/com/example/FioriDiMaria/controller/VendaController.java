package com.example.FioriDiMaria.controller;

import java.util.List;

import com.example.FioriDiMaria.mapper.venda.VendaResponseDTO;
import com.example.FioriDiMaria.mapper.venda.VendaResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<VendaResponseDTO> create(@RequestBody VendaResquestDTO venda){
        return new ResponseEntity<>(vendaService.create(venda), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(vendaService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> getAll(){
        return new ResponseEntity<>(vendaService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaResponseDTO> update(@PathVariable Long id, @RequestBody VendaResquestDTO vendaUpdate){
        return new ResponseEntity<>(vendaService.update(id,vendaUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return new ResponseEntity<>(vendaService.delete(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAll(){
        vendaService.deleteAll();
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
