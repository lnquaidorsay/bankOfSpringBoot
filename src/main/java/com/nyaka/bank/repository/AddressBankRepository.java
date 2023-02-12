package com.nyaka.bank.repository;

import com.nyaka.bank.entity.AddressBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBankRepository extends JpaRepository<AddressBank, Integer> {
}
