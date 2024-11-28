package com.example.FioriDiMaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FioriDiMaria.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
