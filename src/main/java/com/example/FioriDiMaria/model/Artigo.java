package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapper.artigo.ArtigoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "artigos")
@Entity(name = "artigos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Artigo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String corpo;

    public Artigo(ArtigoRequestDTO artigoRequestDTO) {
        this.titulo = artigoRequestDTO.titulo();
        this.corpo = artigoRequestDTO.corpo();
    }
}
