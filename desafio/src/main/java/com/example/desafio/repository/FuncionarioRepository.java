package com.example.desafio.repository;

import com.example.desafio.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
    Optional<FuncionarioEntity> findBycargo (String cargo);
}
