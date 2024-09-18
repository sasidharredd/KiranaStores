package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Transaction;

public interface Transactionrepo extends MongoRepository<Transaction, String> {

//JpaRepository<Transaction, String>{
	List<Transaction> findAllByUserIdAndDateBetween(String userId, LocalDate startDate, LocalDate endDate);
}
