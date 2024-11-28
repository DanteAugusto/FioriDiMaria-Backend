package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.model.enums.UserRole;
import com.example.FioriDiMaria.mapper.usuario.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String senha;
    private UserRole role;

    public Usuario(UsuarioRequestDTO usuarioRequestDTO) {
        this.nome = usuarioRequestDTO.nome();
        this.senha = usuarioRequestDTO.senha();
        this.role = usuarioRequestDTO.role();
    }
}
