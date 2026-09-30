package com.example.desafio.controller;

import com.example.desafio.entity.ClienteEntity;
import com.example.desafio.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteEntity> listarTodos(){
        return service.listarTodosProduto();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody ClienteEntity cliente){
        service.salvarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "CLiente cadastrado com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody ClienteEntity cliente){
        service.atualizarCliente(id, cliente);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente atualizado com sucesso"));
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        service.excluirCliente(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("mensagem", "Cliente excluido com sucesso"));
    }
}
