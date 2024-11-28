package com.example.FioriDiMaria.mapper.usuario;

import com.example.FioriDiMaria.model.enums.UserRole;
import com.example.FioriDiMaria.model.Usuario;

public record UsuarioResponseDTO(long id, String nome, String senha, UserRole role) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(), usuario.getSenha(), usuario.getRole());
    }
}
