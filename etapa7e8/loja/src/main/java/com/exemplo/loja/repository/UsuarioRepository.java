package com.exemplo.loja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.loja.model.Usuario;

import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsuario(String usuario);

}
