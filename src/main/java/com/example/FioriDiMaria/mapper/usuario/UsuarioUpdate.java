package com.example.FioriDiMaria.mapper.usuario;

import com.example.FioriDiMaria.model.enums.TipoUsuario;

public record UsuarioUpdate(
    String nome,
    String login,
    String senha,
    TipoUsuario tipoUsuario)
{}