package com.example.FioriDiMaria.controller;

import java.util.List;

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

import com.example.FioriDiMaria.mapper.venda.VendaCreate;
import com.example.FioriDiMaria.mapper.venda.VendaMapper;
import com.example.FioriDiMaria.mapper.venda.VendaOutput;
import com.example.FioriDiMaria.mapper.venda.VendaUpdate;
import com.example.FioriDiMaria.model.Venda;
import com.example.FioriDiMaria.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
    
    @Autowired
    private VendaService vendaService;

    @Autowired
    private VendaMapper vendaMapper;

    @PostMapping
    public ResponseEntity<VendaOutput> create(@RequestBody VendaCreate vendaCreate){
        Venda venda = vendaMapper.toVendaFromCreate(vendaCreate);
        Venda vendaCriado = vendaService.create(venda);
        VendaOutput vendaOutput = vendaMapper.toVendaOutput(vendaCriado);
        return new ResponseEntity<VendaOutput>(vendaOutput, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaOutput> getById(@PathVariable Long id){
        Venda venda = vendaService.getById(id);
        VendaOutput vendaOutput = vendaMapper.toVendaOutput(venda);
        return new ResponseEntity<VendaOutput>(vendaOutput, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VendaOutput>> getAll(){
        List<Venda> vendas = vendaService.getAll();
        List<VendaOutput> vendasOutput = vendas
                                            .stream()
                                            .map(vendaMapper::toVendaOutput)
                                            .toList();
        return new ResponseEntity<List<VendaOutput>>(vendasOutput, HttpStatus.OK);                                                                                   
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaOutput> update(@PathVariable Long id, @RequestBody VendaUpdate vendaUpdate){
        Venda venda = vendaMapper.toVendaFromUpdate(vendaUpdate);
        Venda vendaAtualizado = vendaService.update(id, venda);
        VendaOutput vendaOutput = vendaMapper.toVendaOutput(venda);
        return new ResponseEntity<VendaOutput>(vendaOutput, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        vendaService.delete(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAll(){
        vendaService.deleteAll();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
