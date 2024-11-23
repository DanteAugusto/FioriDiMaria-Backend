package com.example.FioriDiMaria.usuario;

public record UsuarioResponseDTO(long id, String nome, String senha,UserRole role) {
    public UsuarioResponseDTO(Usuario usuario){
        this(usuario.getId(),usuario.getNome(), usuario.getSenha(), usuario.getRole());
    }
}
