package com.example.FioriDiMaria.Promocao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocaoService {
    @Autowired
    private PromocaoRepository promocaoRepository;

    public List<PromocaoResponseDTO> findAll(){
        return  promocaoRepository.findAll().stream().map(PromocaoResponseDTO::new).toList();
    }

    public PromocaoResponseDTO findById(long id){
        return promocaoRepository.findById(id).map(PromocaoResponseDTO::new).orElse(null);
    }

    public void saveNew(PromocaoRequestDTO dto){
        Promocao promocao = new Promocao(dto);
        promocaoRepository.save(promocao);
    }

    public boolean update(long id, PromocaoRequestDTO dto){
        Optional<Promocao> tryPromocao = promocaoRepository.findById(id);
        if(tryPromocao.isEmpty()){
            return false;
        }
        Promocao promocao = tryPromocao.get();

        promocao.setDataInicio(dto.dataInicio());
        promocao.setDataFim(dto.dataFim());
        promocao.setDescontoPercentual(dto.descontoPercentual());
        promocao.setNome(dto.nome());
        promocaoRepository.save(promocao);
        return true;
    }

    public boolean delete(long id){
        Optional<Promocao> tryPromocao = promocaoRepository.findById(id);
        if(tryPromocao.isEmpty()){
            return false;
        }
        promocaoRepository.delete(tryPromocao.get());
        return true;
    }


}
