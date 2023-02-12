package com.nyaka.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserBank")
public class User extends AbstractEntity implements UserDetails {

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private boolean active;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Contact> contacts;
    @OneToOne
    private Account account; //Je veux que l'entité porteuse(propriétaire) soit Account, car on peut créer un utilisateur sans créer son contact

    @OneToOne
    private AddressBank addressBank;

    @OneToOne
    private Role role;


    //Liste des roles de cette utilisateurs
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }

    //identifiant unique de l'authentification
    @Override
    public String getUsername() {
        return email;
    }

    //false : il est expiré, true : il ne l'est pas
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //le compte n'est pas bloqué
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
