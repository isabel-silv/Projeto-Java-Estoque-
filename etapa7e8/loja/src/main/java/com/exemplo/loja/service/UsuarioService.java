
package com.exemplo.loja.service;

import com.exemplo.loja.model.Usuario;
import com.exemplo.loja.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

     @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setId(null);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar(Integer id, Usuario usuario) {
        Usuario usuarioEncontrado = buscarPorId(id);
        usuarioEncontrado.setUsuario(usuario.getUsuario());
        usuarioEncontrado.setSenha(usuario.getSenha());
        usuarioRepository.save(usuarioEncontrado);
        return usuarioEncontrado;
    }

    public void excluir(Integer id) {
        Usuario usuarioEncontrado = buscarPorId(id);
        usuarioRepository.deleteById(usuarioEncontrado.getId());
    }

    public Usuario buscarPorUsuario(String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }
}
