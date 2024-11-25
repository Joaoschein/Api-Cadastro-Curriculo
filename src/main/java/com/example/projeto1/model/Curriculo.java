package com.example.projeto1.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "curriculos")
public class Curriculo {
    @Id
    private String id;
    private String nome;
    private String telefone;
    private String email;
    private String enderecoWeb;
    private String experiencia;

}
