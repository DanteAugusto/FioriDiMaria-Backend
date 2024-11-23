package com.example.FioriDiMaria.sobreMim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SobreMimService {
    @Autowired
    private SobreMimRepository sobreMimRepository;

    public List<SobreMimResponseDTO> getAllSobreMim() {
        return sobreMimRepository.findAll().stream().map(SobreMimResponseDTO::new).toList();
    }

    public SobreMimResponseDTO findById(long id) {
        return sobreMimRepository.findById(id).map(SobreMimResponseDTO::new).orElse(null);
    }

    public void saveNew(SobreMimRequestDTO dto) {
        SobreMim sobreMim = new SobreMim(dto);
        sobreMimRepository.save(sobreMim);
    }

    public boolean update(long id, SobreMimRequestDTO dto) {
        Optional<SobreMim> trySobreMim = sobreMimRepository.findById(id);
        if (trySobreMim.isEmpty()) return false;

        SobreMim sobreMim = trySobreMim.get();

        sobreMim.setTexto(dto.texto());
        sobreMimRepository.save(sobreMim);
        return true;
    }

    public boolean delete(long id) {
        Optional<SobreMim> sobreMim = sobreMimRepository.findById(id);
        if (sobreMim.isEmpty()) return false;
        sobreMimRepository.deleteById(id);
        return true;
    }
}
