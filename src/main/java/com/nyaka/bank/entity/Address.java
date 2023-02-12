package com.nyaka.bank.entity;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private Integer id;

    private String street;

    @OneToOne
    @JoinColumn(name = "id_student")
    private Student student;
}
