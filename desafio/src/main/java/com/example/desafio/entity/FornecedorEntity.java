package com.example.desafio.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_fornecedor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FornecedorEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razaosocial;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefone;
}

