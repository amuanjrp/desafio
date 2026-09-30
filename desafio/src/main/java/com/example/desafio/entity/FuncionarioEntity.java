package com.example.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "tab_funcionarios")
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String dataAdmissao;
}
