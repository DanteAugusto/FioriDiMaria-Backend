package com.example.FioriDiMaria.mapper.endereco;

public record EnderecoRequestDTO
        (String nome,
         String cep,
         String rua,
         String bairro,
         String cidade,
         String estado,
         String pais,
         String numero,
         String complemento) {
}