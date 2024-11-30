package com.example.FioriDiMaria.controller;

import com.example.FioriDiMaria.mapper.usuario.UsuarioRequestDTO;
import com.example.FioriDiMaria.mapper.usuario.UsuarioResponseDTO;
import com.example.FioriDiMaria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAll(){
        return new ResponseEntity<List<UsuarioResponseDTO>>(usuarioService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> newUsuario(@RequestBody UsuarioRequestDTO usuario){
        UsuarioResponseDTO response = usuarioService.saveNew(usuario);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable int id, @RequestBody UsuarioRequestDTO usuario){
        UsuarioResponseDTO response = usuarioService.update(id, usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable int id){
        return new ResponseEntity<>(usuarioService.delete(id), HttpStatus.OK);
    }

}
