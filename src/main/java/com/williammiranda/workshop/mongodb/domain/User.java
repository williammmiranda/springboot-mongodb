package com.williammiranda.workshop.mongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String nome;
    private String email;

}
