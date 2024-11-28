package com.example.FioriDiMaria.mapper.sobreMim;

import com.example.FioriDiMaria.model.SobreMim;

public record SobreMimResponseDTO(long id, String texto) {
    public SobreMimResponseDTO(SobreMim sobreMim) {
        this(sobreMim.getId(), sobreMim.getTexto());
    }
}
