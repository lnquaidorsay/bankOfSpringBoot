package com.nyaka.bank.repository;

import com.nyaka.bank.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository  extends JpaRepository<Contact, Integer> {
    List<Contact> findAllByUserId(Integer userId);
}
