package com.example.desafio.controller;

import com.example.desafio.entity.ProdutoEntity;
import com.example.desafio.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoEntity> listarTodosProdutos(){
        return service.listaProdutos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody ProdutoEntity produto){
        service.salvarProduto(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("msg", "Produto salvo com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody ProdutoEntity produto){
        service.atualizarProduto(id, produto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("msg", "ProdutoAtualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        service.removerProduto(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("msg", "ProdutoRemovido com sucesso"));

    }
}
