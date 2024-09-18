package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransactionDTO;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
   private final TransactionService transactionService;

	    public TransactionController(TransactionService transactionService) {
	        this.transactionService = transactionService;
	    
	    }
	    @PostMapping
	    public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) {
	        Transaction transaction = transactionService.recordTransaction(transactionDTO);
	        return ResponseEntity.ok(transaction);
	    }

	}


