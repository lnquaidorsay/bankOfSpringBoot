package com.nyaka.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RoleUserBank")
public class Role extends AbstractEntity {

    private String name;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
}
