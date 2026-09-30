package com.example.desafio.service;

import com.example.desafio.entity.ServicoEntity;
import com.example.desafio.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repository;

    public List<ServicoEntity> listarServicos(){return repository.findAll();}

    public ServicoEntity salvarServico(ServicoEntity servico){
        if (repository.findByDescricao(servico.getDescricao()).isPresent())
            throw new IllegalArgumentException("Serviço já cadastrado");
        return repository.save(servico);
    }

    //UPDATE
    public ServicoEntity atualizarServico(Long id, ServicoEntity produto){
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Servico não encontrado");
        }
        produto.setId(id);
        return repository.save(produto);

    }

    //DELETE
    public  void removerServico(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Servico não encontrado");
        }
        repository.deleteById(id);
    }
}
