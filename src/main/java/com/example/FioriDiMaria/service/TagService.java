package com.example.FioriDiMaria.service;

import com.example.FioriDiMaria.mapper.produto.ProdutoRequestDTO;
import com.example.FioriDiMaria.mapper.produto.ProdutoResponseDTO;
import com.example.FioriDiMaria.mapper.tag.TagRequestDTO;
import com.example.FioriDiMaria.mapper.tag.TagResponseDTO;
import com.example.FioriDiMaria.model.Produto;
import com.example.FioriDiMaria.model.Tag;
import com.example.FioriDiMaria.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<TagResponseDTO> findAll() {
        return tagRepository.findAll().stream().map(TagResponseDTO::new).toList();
    }
    public TagResponseDTO findById(Long id) {
        return tagRepository.findById(id).map(TagResponseDTO::new).orElse(null);
    }

    public void saveNew(TagRequestDTO dto) {
        Tag tag = new Tag(dto);
        tagRepository.save(tag);
    }

    public boolean update(long id, TagRequestDTO dto) {
        Optional<Tag> tryTag = tagRepository.findById(id);
        if (tryTag.isEmpty()) return false;

        Tag tag = tryTag.get();

        tag.setNome(dto.nome());
        tagRepository.save(tag);
        return true;
    }

    public boolean delete(long id) {
        Optional<Tag> tryTag = tagRepository.findById(id);
        if (tryTag.isEmpty()) return false;
        tagRepository.delete(tryTag.get());
        return true;
    }
}
