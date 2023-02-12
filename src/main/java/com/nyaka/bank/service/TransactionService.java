package com.nyaka.bank.service;

import com.nyaka.bank.dto.TransactionDto;

import java.util.List;

public interface TransactionService extends AbstractService<TransactionDto> {
    List<TransactionDto> findAllByUserId(Integer userId);
}
