package com.example.FioriDiMaria.service;


import com.example.FioriDiMaria.model.Usuario;
import com.example.FioriDiMaria.repository.UsuarioRepository;
import com.example.FioriDiMaria.mapper.usuario.UsuarioRequestDTO;
import com.example.FioriDiMaria.mapper.usuario.UsuarioResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDTO> getAll() {
        return usuarioRepository.findAll().stream().map(UsuarioResponseDTO::new).toList();
    }

    public UsuarioResponseDTO findById(long id) {
        return usuarioRepository.findById(id).map(UsuarioResponseDTO::new).orElse(null);
    }

    public UsuarioResponseDTO saveNew(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    public UsuarioResponseDTO update(long id, UsuarioRequestDTO dto) {
        Optional<Usuario> tryUsuario = usuarioRepository.findById(id);
        // throw an exception in that case
        if (tryUsuario.isEmpty()) return null;
        Usuario usuario = tryUsuario.get();

        usuario.setNome(dto.nome());
        usuario.setTipo(dto.tipo());
        usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    public boolean delete(long id) {
        Optional<Usuario> tryUsuario = usuarioRepository.findById(id);
        // throw an exception in that case
        if (tryUsuario.isEmpty()) return false;
        usuarioRepository.delete(tryUsuario.get());
        return true;
    }

}
