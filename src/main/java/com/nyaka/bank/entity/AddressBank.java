package com.nyaka.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AddressBank extends  AbstractEntity {

    private String street;

    private Integer houseNumber;

    private Integer zipCode;

    private String city;

    private String country;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}