package com.example.FioriDiMaria.mapper.tag;

import com.example.FioriDiMaria.model.Produto;
import com.example.FioriDiMaria.model.Tag;

public record TagResponseDTO(long id, String nome) {
    public TagResponseDTO(Tag tag) {
        this(tag.getId(), tag.getNome());
    }
}
