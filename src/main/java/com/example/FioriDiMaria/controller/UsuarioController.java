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

import com.example.FioriDiMaria.mapper.usuario.UsuarioCreate;
import com.example.FioriDiMaria.mapper.usuario.UsuarioMapper;
import com.example.FioriDiMaria.mapper.usuario.UsuarioOutput;
import com.example.FioriDiMaria.mapper.usuario.UsuarioUpdate;
import com.example.FioriDiMaria.model.Usuario;
import com.example.FioriDiMaria.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioOutput> create(@RequestBody UsuarioCreate usuarioCreate){
        Usuario usuario = usuarioMapper.toUsuarioFromCreate(usuarioCreate);
        Usuario usuarioCriado = usuarioService.create(usuario);
        UsuarioOutput usuarioOutput = usuarioMapper.toUsuarioOutput(usuarioCriado);
        return new ResponseEntity<UsuarioOutput>(usuarioOutput, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOutput> getById(@PathVariable Long id){
        Usuario usuario = usuarioService.getById(id);
        UsuarioOutput usuarioOutput = usuarioMapper.toUsuarioOutput(usuario);
        return new ResponseEntity<UsuarioOutput>(usuarioOutput, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioOutput>> getAll(){
        List<Usuario> usuarios = usuarioService.getAll();
        List<UsuarioOutput> usuariosOutput = usuarios
                                            .stream()
                                            .map(usuarioMapper::toUsuarioOutput)
                                            .toList();
        return new ResponseEntity<List<UsuarioOutput>>(usuariosOutput, HttpStatus.OK);                                                                                   
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioOutput> update(@PathVariable Long id, @RequestBody UsuarioUpdate usuarioUpdate){
        Usuario usuario = usuarioMapper.toUsuarioFromUpdate(usuarioUpdate);
        Usuario usuarioAtualizado = usuarioService.update(id, usuario);
        UsuarioOutput usuarioOutput = usuarioMapper.toUsuarioOutput(usuario);
        return new ResponseEntity<UsuarioOutput>(usuarioOutput, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        usuarioService.delete(id);
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> deleteAll(){
        usuarioService.deleteAll();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}
