package com.example.desafio.controller;

import com.example.desafio.entity.ServicoEntity;
import com.example.desafio.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/serviços")
public class ServicoController {
    @Autowired
    private ServicoService service;

    @GetMapping
    public List<ServicoEntity> listarTodosServicos(){
        return service.listarServicos();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody ServicoEntity produto){
        service.salvarServico(produto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("msg", "Servico salvo com sucesso"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @RequestBody ServicoEntity produto){
        service.atualizarServico(id, produto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("msg", "ServicoAtualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluir(@PathVariable Long id){
        service.removerServico(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("msg", "ServicoRemovido com sucesso"));

    }
}
