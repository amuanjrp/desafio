package com.example.desafio.service;

import com.example.desafio.entity.ClienteEntity;
import com.example.desafio.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository reposity;

    public List<ClienteEntity> listarTodosProduto(){
        return reposity.findAll();
    }


    public ClienteEntity salvarCliente (ClienteEntity cliente){
        if (reposity.findByemail(cliente.getEmail()).isPresent())
            throw new IllegalArgumentException("Cliente já cadastrado.");

        return reposity.save(cliente);
    }

    public ClienteEntity atualizarCliente (Long id, ClienteEntity cliente){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado.");

        cliente.setId(id);
        return reposity.save(cliente);
    }

    public void excluirCliente (Long id){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Cliente não encontrado.");

        reposity.deleteById(id);
    }
}
