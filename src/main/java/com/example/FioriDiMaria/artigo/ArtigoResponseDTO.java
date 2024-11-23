package com.example.FioriDiMaria.artigo;

public record ArtigoResponseDTO(long id, String titulo, String corpo) {
    public ArtigoResponseDTO(Artigo artigo){
        this(artigo.getId(), artigo.getTitulo(), artigo.getCorpo());
    }
}
