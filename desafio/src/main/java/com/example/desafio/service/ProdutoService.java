package com.example.desafio.service;

import com.example.desafio.entity.ProdutoEntity;
import com.example.desafio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    //READ
    public List<ProdutoEntity> listaProdutos(){
        return repository.findAll();
    }

    //CREATE
    public  ProdutoEntity salvarProduto(ProdutoEntity produto){
        if (produto.getDescricao() != null && repository.existsById(produto.getId())){
            throw new IllegalArgumentException("Produto já cadastrado");
        }
        return repository.save(produto);

    }

    //UPDATE
    public ProdutoEntity atualizarProduto(Long id, ProdutoEntity produto){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado");
        }
            produto.setId(id);
            return repository.save(produto);

    }

    //DELETE
    public  void removerProduto(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Produto não encontrado");
        }
        repository.deleteById(id);
    }
}
