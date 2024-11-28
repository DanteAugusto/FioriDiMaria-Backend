package com.example.FioriDiMaria.controllers;

import com.example.FioriDiMaria.mapper.sobreMim.SobreMimRequestDTO;
import com.example.FioriDiMaria.mapper.sobreMim.SobreMimResponseDTO;
import com.example.FioriDiMaria.service.SobreMimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sobre_mim")
public class SobreMimController {
    @Autowired
    private SobreMimService sobreMimService;

    @GetMapping
    public List<SobreMimResponseDTO> getAll(){
        return sobreMimService.getAllSobreMim();
    }

    @PostMapping
    public void newSobreMim(@RequestBody SobreMimRequestDTO sobreMim){
        sobreMimService.saveNew(sobreMim);
    }

    @PutMapping("/{id}")
    public void updateSobreMim(@PathVariable int id, @RequestBody SobreMimRequestDTO sobreMim){
        sobreMimService.update(id, sobreMim);
    }

    @DeleteMapping("/{id}")
    public void deleteSobreMim(@PathVariable int id){
        sobreMimService.delete(id);
    }
}
