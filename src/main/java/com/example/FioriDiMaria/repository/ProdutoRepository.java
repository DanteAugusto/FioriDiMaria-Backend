package com.example.FioriDiMaria.repository;

import com.example.FioriDiMaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
