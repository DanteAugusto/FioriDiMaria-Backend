package com.example.FioriDiMaria.repository;

import com.example.FioriDiMaria.model.VendaIndividual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendaIndividualRepository extends JpaRepository<VendaIndividual, Long> {
    List<VendaIndividual> findByVendaId(Long id);
}
