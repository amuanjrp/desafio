package com.example.desafio.service;

import com.example.desafio.entity.PetEntity;
import com.example.desafio.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository reposity;

    public List<PetEntity> listarTodosProduto(){
        return reposity.findAll();
    }


    public PetEntity salvarPet (PetEntity pet){
        if (reposity.findByespecie(pet.getEspecie()).isPresent())
            throw new IllegalArgumentException("Pet já cadastrado.");

        return reposity.save(pet);
    }

    public PetEntity atualizarPet (Long id, PetEntity pet){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Pet não encontrado.");

        pet.setId(id);
        return reposity.save(pet);
    }

    public void excluirPet (Long id){
        if(!reposity.existsById(id))
            throw new IllegalArgumentException("Pet não encontrado.");

        reposity.deleteById(id);
    }
}
