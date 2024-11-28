package com.example.FioriDiMaria.controllers;

import com.example.FioriDiMaria.mapper.usuario.UsuarioRequestDTO;
import com.example.FioriDiMaria.mapper.usuario.UsuarioResponseDTO;
import com.example.FioriDiMaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDTO> getAll(){
        return usuarioService.getAll();
    }

    @PostMapping
    public void newUsuario(@RequestBody UsuarioRequestDTO usuario){
        usuarioService.saveNew(usuario);
    }

    @PutMapping("/{id}")
    public void updateUsuario(@PathVariable int id, @RequestBody UsuarioRequestDTO usuario){
        usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable int id){
        usuarioService.delete(id);
    }

}
