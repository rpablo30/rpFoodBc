package com.api.rpfood.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pasteis")
public class Pastel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int opcionais;
    private Integer vendaSugestiva;
    private String imagem;


}
