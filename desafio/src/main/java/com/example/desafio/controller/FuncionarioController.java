package com.example.desafio.controller;

import com.example.desafio.entity.FuncionarioEntity;
import com.example.desafio.entity.ProdutoEntity;
import com.example.desafio.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioEntity> listarTodosFuncionarios() {return service.ListarTodosFuncionarios();}

    @PostMapping
    public ResponseEntity<Map<String, String>> salvar(@RequestBody FuncionarioEntity funcionario){
        service.salvarFuncionario(funcionario);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("msg", "Funcionario salvo com sucesso"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizarFuncionario (@PathVariable Long id, @RequestBody FuncionarioEntity funcionario){
        service.atualizarFuncionario(id, funcionario);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("msg", "Funcionario atualizado com sucesso"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> excluirFuncionario(@PathVariable Long id){
        service.excluirFuncionario(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("msg", "Funcionario excluido com sucesso"));
    }
}
