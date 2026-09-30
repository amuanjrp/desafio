package com.example.desafio.service;

import com.example.desafio.entity.FuncionarioEntity;
import com.example.desafio.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public List<FuncionarioEntity> ListarTodosFuncionarios() {return repository.findAll();}

    public FuncionarioEntity salvarFuncionario (FuncionarioEntity funcionario){
        if (repository.findBycargo(funcionario.getCargo()).isPresent())
            throw new IllegalArgumentException("Funcionario já cadastrado.");

        return repository.save(funcionario);
    }

    public FuncionarioEntity atualizarFuncionario (Long id, FuncionarioEntity funcionario){
        if(!repository.existsById(id))
            throw new IllegalArgumentException("Funcionario não encontrado");

        funcionario.setId(id);
        return repository.save(funcionario);
    }

    public void excluirFuncionario (Long id){
        if(!repository.existsById(id))
            throw new IllegalArgumentException("Funcionario não encontrado.");

        repository.deleteById(id);
    }

}
