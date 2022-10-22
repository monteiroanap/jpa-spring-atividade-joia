package br.dh.meli.storage02.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "joia")
@Data
public class Joia {

    @Id // chave primaria PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // estrategias de criaçao dos Ids.
    private Long id;

    @Column(length = 50, nullable = false ) // nullable aqui pode ser true ou false, podendo ser nulo ou nao esse campo
    private String material;

    @Column(length = 20, nullable = false)
    private Double peso;

    @Column(length = 20, nullable = false)
    private Integer quilates;

}
