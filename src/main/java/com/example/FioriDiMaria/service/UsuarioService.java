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

    public void saveNew(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario(dto);
        usuarioRepository.save(usuario);
    }

    public boolean update(long id, UsuarioRequestDTO dto) {
        Optional<Usuario> tryUsuario = usuarioRepository.findById(id);
        if (tryUsuario.isEmpty()) return false;
        Usuario usuario = tryUsuario.get();

        usuario.setNome(dto.nome());
        usuario.setRole(dto.role());
        usuarioRepository.save(usuario);
        return true;
    }

    public boolean delete(long id) {
        Optional<Usuario> tryUsuario = usuarioRepository.findById(id);
        if (tryUsuario.isEmpty()) return false;
        usuarioRepository.delete(tryUsuario.get());
        return true;
    }
  
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario update(Long id, Usuario usuario) {
        Usuario usuarioExistente = this.getById(id);

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setLogin(usuario.getLogin());
        usuarioExistente.setSenha(usuario.getSenha());
        usuarioExistente.setTipoUsuario(usuario.getTipoUsuario());

        return usuarioRepository.save(usuarioExistente);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void deleteAll() {
        usuarioRepository.deleteAll();
    }

}
