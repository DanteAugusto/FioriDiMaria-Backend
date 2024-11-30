package com.example.FioriDiMaria.mapper.artigo;

import com.example.FioriDiMaria.model.Artigo;

public record ArtigoResponseDTO(long id, String titulo, String corpo) {
    public ArtigoResponseDTO(Artigo artigo){
        this(artigo.getId(), artigo.getTitulo(), artigo.getCorpo());
    }
}
