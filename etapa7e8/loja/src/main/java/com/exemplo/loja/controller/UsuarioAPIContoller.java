
package com.exemplo.loja.controller;

import com.exemplo.loja.model.Usuario;
import com.exemplo.loja.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioAPIContoller {
    @Autowired
    UsuarioService usuarioService;
    
   @GetMapping("buscar/{id}")
    public ResponseEntity<Usuario> pesquisar(@PathVariable Integer id){
        Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(usuarioEncontrado, HttpStatus.OK);
    }
     @PostMapping("/adicionar")
    public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario){
     Usuario novoFilme = usuarioService.criarUsuario(usuario);
       return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }
    @GetMapping("listar-todos")
    public ResponseEntity<List> listar(){
        List<Usuario> usuarioU = usuarioService.listarTodos();
        return new ResponseEntity<>(usuarioU, HttpStatus.OK);
    }
     @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
  

