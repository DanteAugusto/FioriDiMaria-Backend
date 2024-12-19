package com.example.FioriDiMaria.service;

import com.example.FioriDiMaria.mapper.endereco.EnderecoRequestDTO;
import com.example.FioriDiMaria.mapper.endereco.EnderecoResponseDTO;
import com.example.FioriDiMaria.model.Endereco;
import com.example.FioriDiMaria.model.Usuario;
import com.example.FioriDiMaria.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private UsuarioService usuarioService;

    public List<EnderecoResponseDTO> findAll() {
        return enderecoRepository.findAll().stream().map(EnderecoResponseDTO::new).toList();
    }
    public EnderecoResponseDTO findById(Long id) {
        return enderecoRepository.findById(id).map(EnderecoResponseDTO::new).orElse(null);
    }

    public void saveNew(EnderecoRequestDTO dto, Long userId) {
        Usuario ususario = usuarioService.getUser(userId);
        Endereco endereco = new Endereco(dto, ususario);
        enderecoRepository.save(endereco);
    }

    public boolean update(long id, EnderecoRequestDTO dto) {
        Optional<Endereco> tryEndereco = enderecoRepository.findById(id);
        if (tryEndereco.isEmpty()) return false;

        Endereco endereco = tryEndereco.get();

        endereco.setNome(dto.nome());
        endereco.setCep(dto.cep());
        endereco.setBairro(dto.bairro());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setPais(dto.pais());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());

        enderecoRepository.save(endereco);
        return true;
    }

    public boolean delete(long id) {
        Optional<Endereco> tryEndereco = enderecoRepository.findById(id);
        if (tryEndereco.isEmpty()) return false;
        enderecoRepository.delete(tryEndereco.get());
        return true;
    }
}
