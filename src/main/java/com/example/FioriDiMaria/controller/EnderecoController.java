package com.example.FioriDiMaria.controller;

import com.example.FioriDiMaria.mapper.endereco.EnderecoRequestDTO;
import com.example.FioriDiMaria.mapper.endereco.EnderecoResponseDTO;
import com.example.FioriDiMaria.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<EnderecoResponseDTO> getAll(){
        return service.findAll();
    }

    @PostMapping("/{userId}")
    public boolean newEndereco(@RequestBody EnderecoRequestDTO endereco, @PathVariable Long userId){
        return service.saveNew(endereco, userId);
    }

    @PutMapping("/{id}")
    public void updateEndereco(@PathVariable int id, @RequestBody EnderecoRequestDTO endereco){
        service.update(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void deleteArtigo(@PathVariable int id){
        service.delete(id);
    }
}
