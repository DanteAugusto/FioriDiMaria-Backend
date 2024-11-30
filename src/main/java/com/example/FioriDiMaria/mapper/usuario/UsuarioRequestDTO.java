package com.example.FioriDiMaria.mapper.usuario;

import com.example.FioriDiMaria.model.enums.TipoUsuario;

public record UsuarioRequestDTO(String nome, String email, String senha, TipoUsuario tipo) {
}
