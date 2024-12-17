package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapper.produto.ProdutoRequestDTO;
import com.example.FioriDiMaria.mapper.tag.TagRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Table(name = "tags")
@Entity(name = "tags")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tag {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToMany
    @JoinTable(
            name = "tag_produto",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos = new HashSet<>();

    public Tag(TagRequestDTO tagRequestDTO) {
        this.nome = tagRequestDTO.nome();
    }

}
