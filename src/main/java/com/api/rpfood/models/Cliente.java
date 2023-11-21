package com.api.rpfood.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}
