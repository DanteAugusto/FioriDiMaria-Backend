package com.example.FioriDiMaria.mapper.endereco;

import com.example.FioriDiMaria.model.Endereco;

public record EnderecoResponseDTO
        (
                Long id,
                String nome,
                String cep,
                String rua,
                String bairro,
                String cidade,
                String estado,
                String pais,
                String numero,
                String complemento
        ){
    public EnderecoResponseDTO(Endereco endereco) {
        this(
                endereco.getId(),
                endereco.getNome(),
                endereco.getCep(),
                endereco.getRua(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getPais(),
                endereco.getNumero(),
                endereco.getComplemento()
        );
    }
}
