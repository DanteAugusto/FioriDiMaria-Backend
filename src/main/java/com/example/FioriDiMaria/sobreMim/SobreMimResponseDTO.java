package com.example.FioriDiMaria.sobreMim;

public record SobreMimResponseDTO(long id, String texto) {
    public SobreMimResponseDTO(SobreMim sobreMim) {
        this(sobreMim.getId(), sobreMim.getTexto());
    }
}
