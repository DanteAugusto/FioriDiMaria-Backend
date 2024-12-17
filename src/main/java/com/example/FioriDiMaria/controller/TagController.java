package com.example.FioriDiMaria.controller;

import com.example.FioriDiMaria.mapper.tag.TagRequestDTO;
import com.example.FioriDiMaria.mapper.tag.TagResponseDTO;
import com.example.FioriDiMaria.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public List<TagResponseDTO> getAll() {
        return tagService.findAll();
    }

    @PostMapping
    public void newProduct(@RequestBody TagRequestDTO tag) {
        tagService.saveNew(tag);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody TagRequestDTO tag) {
        tagService.update(id, tag);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        tagService.delete(id);
    }
}