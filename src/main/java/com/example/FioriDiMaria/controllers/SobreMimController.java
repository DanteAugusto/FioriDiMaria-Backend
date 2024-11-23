package com.example.FioriDiMaria.controllers;

import com.example.FioriDiMaria.sobreMim.SobreMimRequestDTO;
import com.example.FioriDiMaria.sobreMim.SobreMimResponseDTO;
import com.example.FioriDiMaria.sobreMim.SobreMimService;
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
    public void NewSobreMim(@RequestBody SobreMimRequestDTO sobreMim){
        sobreMimService.saveNew(sobreMim);
    }

    @PutMapping("/{id}")
    public void UpdateSobreMim(@PathVariable int id, @RequestBody SobreMimRequestDTO sobreMim){
        sobreMimService.update(id, sobreMim);
    }

    @DeleteMapping("/{id}")
    public void DeleteSobreMim(@PathVariable int id){
        sobreMimService.delete(id);
    }
}
