package com.example.FioriDiMaria.usuario;

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
}
