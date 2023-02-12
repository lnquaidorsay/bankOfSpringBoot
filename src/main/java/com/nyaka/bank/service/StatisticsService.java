package com.nyaka.bank.service;

import com.nyaka.bank.dto.TransactionSumDetails;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface StatisticsService {
    List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);

    BigDecimal getAccountBalance(Integer userId);

    BigDecimal highestTransfer(Integer userId);

    BigDecimal highestDeposit(Integer userId);
}
