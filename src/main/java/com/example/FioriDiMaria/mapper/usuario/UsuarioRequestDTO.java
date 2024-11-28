package com.example.FioriDiMaria.mapper.usuario;

import com.example.FioriDiMaria.model.enums.UserRole;

public record UsuarioRequestDTO(String nome, String senha, UserRole role) {
}
