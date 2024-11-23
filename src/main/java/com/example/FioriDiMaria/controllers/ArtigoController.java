package com.example.FioriDiMaria.controllers;

import com.example.FioriDiMaria.artigo.ArtigoRequestDTO;
import com.example.FioriDiMaria.artigo.ArtigoResponseDTO;
import com.example.FioriDiMaria.artigo.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artigo")
public class ArtigoController {
    @Autowired
    private ArtigoService artigoService;

    @GetMapping
    public List<ArtigoResponseDTO> getAll(){
        return artigoService.getAll();
    }

    @PostMapping
    public void newArtigo(@RequestBody ArtigoRequestDTO artigo){
        artigoService.saveNew(artigo);
    }

    @PutMapping("/{id}")
    public void updateArtigo(@PathVariable int id, @RequestBody ArtigoRequestDTO artigo){
        artigoService.update(id, artigo);
    }

    @DeleteMapping("/{id}")
    public void deleteArtigo(@PathVariable int id){
        artigoService.delete(id);
    }

}
