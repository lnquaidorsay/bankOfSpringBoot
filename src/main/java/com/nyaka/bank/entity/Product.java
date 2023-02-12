package com.nyaka.bank.entity;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String code;
    private double prix;
    @ManyToOne
    @JoinColumn(name="id_cat")
    private Category category; //Exemples les produits (Coca,Eau gazefié, Eau normale, limonande appartiennent à la category Boisson)
}
