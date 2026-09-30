package com.example.desafio.repository;

import com.example.desafio.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<ServicoEntity, Long> {
    Optional<ServicoEntity> findByDescricao(String descricao);
}
