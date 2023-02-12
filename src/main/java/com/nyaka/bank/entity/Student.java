package com.nyaka.bank.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "prenom", length = 1024, updatable = false,insertable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @OneToOne(mappedBy = "student")
    private Address address;
}
