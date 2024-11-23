package com.example.FioriDiMaria.sobreMim;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "sobreMins")
@Entity(name = "sobreMins")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class SobreMim {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String texto;

    public SobreMim(SobreMimRequestDTO sobreMimRequestDTO) {
        this.texto = sobreMimRequestDTO.texto();
    }
}
