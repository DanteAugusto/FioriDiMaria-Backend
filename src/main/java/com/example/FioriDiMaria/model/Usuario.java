package com.example.FioriDiMaria.model;

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

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String nome;

    String login;

    String senha;

    private TipoUsuario tipoUsuario;

    @OneToMany(mappedBy="usuario")
    private List<Venda> vendas = new ArrayList<Venda>();
}
