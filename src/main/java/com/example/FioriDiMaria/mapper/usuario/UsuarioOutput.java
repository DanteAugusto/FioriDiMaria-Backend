package com.example.FioriDiMaria.mapper.usuario;

import java.util.List;

import com.example.FioriDiMaria.model.enums.TipoUsuario;

public record UsuarioOutput(
    Long id,
    String nome,
    String login,
    String senha,
    TipoUsuario tipoUsuario,
    List<Long> vendasIds)
{}