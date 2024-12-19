package com.example.FioriDiMaria.model;

import com.example.FioriDiMaria.mapper.endereco.EnderecoRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "enderecos")
@Entity(name = "enderecos")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String numero;
    private String complemento;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy="endereco")
    private List<Venda> vendas = new ArrayList<>();

    public Endereco(EnderecoRequestDTO endereco, Usuario usuario) {
        this.nome = endereco.nome();
        this.cep = endereco.cep();
        this.rua = endereco.rua();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.estado = endereco.estado();
        this.pais = endereco.pais();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.usuario = usuario;
    }

}
