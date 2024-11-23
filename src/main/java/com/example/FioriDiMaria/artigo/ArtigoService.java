package com.example.FioriDiMaria.artigo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {
    @Autowired
    private ArtigoRepository artigoRepository;

    public List<ArtigoResponseDTO> getAll(){
        return artigoRepository.findAll().stream().map(ArtigoResponseDTO::new).toList();
    }

    public ArtigoResponseDTO getById(long id){
        return artigoRepository.findById(id).map(ArtigoResponseDTO::new).orElse(null);
    }

    public void saveNew(ArtigoRequestDTO dto){
        Artigo artigo = new Artigo(dto);
        artigoRepository.save(artigo);
    }

    public boolean update(long id, ArtigoRequestDTO dto){
        Optional<Artigo> tryArtigo = artigoRepository.findById(id);
        if(tryArtigo.isEmpty()){
            return false;
        }
        Artigo artigo = tryArtigo.get();

        artigo.setTitulo(dto.titulo());
        artigo.setCorpo(dto.corpo());
        artigoRepository.save(artigo);
        return true;
    }

    public boolean delete(long id){
        Optional<Artigo> tryArtigo = artigoRepository.findById(id);
        if(tryArtigo.isEmpty()) return false;
        artigoRepository.delete(tryArtigo.get());
        return true;
    }
}
