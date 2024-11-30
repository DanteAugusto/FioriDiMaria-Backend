package com.example.FioriDiMaria.mapper.usuario;

import com.example.FioriDiMaria.model.enums.TipoUsuario;
import com.example.FioriDiMaria.model.Usuario;

public record UsuarioResponseDTO(long id, String nome, String email, String senha, TipoUsuario tipo) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getTipo());
    }
}
