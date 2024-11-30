package com.example.FioriDiMaria.model;


import com.example.FioriDiMaria.mapper.usuario.UsuarioRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import com.example.FioriDiMaria.model.enums.TipoUsuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "usuarios")
@Entity(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipo;

    public Usuario(UsuarioRequestDTO usuarioRequestDTO) {
        this.nome = usuarioRequestDTO.nome();
        this.email = usuarioRequestDTO.email();
        this.senha = usuarioRequestDTO.senha();
        this.tipo = usuarioRequestDTO.tipo();
    }

    @OneToMany(mappedBy="usuario")
    private List<Venda> vendas = new ArrayList<>();

}
