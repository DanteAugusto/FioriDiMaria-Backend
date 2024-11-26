package com.example.FioriDiMaria.model.enums;

public enum TipoUsuario {
    ADMINISTRADOR("Administrador"),
    PADRAO("Padrão");

    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }
}

