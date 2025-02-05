package com.example.FioriDiMaria.controller;

import com.example.FioriDiMaria.mapper.Promocao.PromocaoRequestDTO;
import com.example.FioriDiMaria.mapper.Promocao.PromocaoResponseDTO;
import com.example.FioriDiMaria.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promocao")
public class PromocaoController {
    @Autowired
    private PromocaoService promocaoService;

    @GetMapping
    public List<PromocaoResponseDTO> getAll(){
        return promocaoService.findAll();
    }

    @PostMapping
    public void newPromocao(@RequestBody PromocaoRequestDTO promocao){
        promocaoService.saveNew(promocao);
    }

    @PutMapping("/{id}")
    public void updatePromocao(@PathVariable int id, @RequestBody PromocaoRequestDTO promocao){
        promocaoService.update(id, promocao);
    }

    @DeleteMapping("/{id}")
    public void deletePromocao(@PathVariable int id){
        promocaoService.delete(id);
    }

}
