package com.example.desafio.service;

import com.example.desafio.entity.FornecedorEntity;
import com.example.desafio.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository reposity;

    public List<FornecedorEntity> listarTodosProduto(){
        return reposity.findAll();
    }


    public FornecedorEntity salvarFornecedor (FornecedorEntity cliente){
        if (reposity.findBycnpj(cliente.getCnpj()).isPresent())
            throw new IllegalArgumentException("Fornecedor já cadastrado.");

        return reposity.save(cliente);
    }

    public FornecedorEntity atualizarFornecedor (Long id, FornecedorEntity cliente){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Fornecedor não encontrado.");

        cliente.setId(id);
        return reposity.save(cliente);
    }

    public void excluirFornecedor (Long id){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Fornecedor não encontrado.");

        reposity.deleteById(id);
    }
}
