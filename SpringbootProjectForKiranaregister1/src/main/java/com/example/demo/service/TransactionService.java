package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.model.Transaction;
import com.example.demo.repository.Transactionrepo;

@Service
public class TransactionService {
    @Autowired
    private Transactionrepo transactionRepository;

    @Autowired
    private currencyservice currencyConverterService;

    public Transaction recordTransaction(TransactionDTO transactionDTO) {
        Double convertedAmount = currencyConverterService.convertCurrency(transactionDTO.getCurrency(), transactionDTO.getAmount());

        Transaction transaction = new Transaction();
        transaction.setType(transactionDTO.getType());
        transaction.setAmount(convertedAmount);
        transaction.setCurrency("INR"); // Assuming base currency is INR
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setDate(LocalDate.now());

        return transactionRepository.save(transaction);
    }

    // Additional methods for generating reports can be added here
}

