package com.example.desafio.controller;

import com.example.desafio.entity.FornecedorEntity;
import com.example.desafio.service.FornecedorService;
import com.example.desafio.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<FornecedorEntity> listarTodos(){
        return service.listarTodosProduto();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody FornecedorEntity fornecedor){
        service.salvarFornecedor(fornecedor);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "CLiente cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody FornecedorEntity fornecedor){
        service.atualizarFornecedor(id, fornecedor);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedor atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        service.excluirFornecedor(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Fornecedor excluido com sucesso"));
    }
}
