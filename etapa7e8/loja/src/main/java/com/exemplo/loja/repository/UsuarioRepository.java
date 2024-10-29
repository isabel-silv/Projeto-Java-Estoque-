package com.exemplo.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.loja.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsuario(String usuario);
}


