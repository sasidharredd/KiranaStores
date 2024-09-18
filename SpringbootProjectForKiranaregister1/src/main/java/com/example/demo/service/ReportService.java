package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.Transactionrepo;

@Service
public class ReportService {
	    @Autowired
	    private Transactionrepo transactionRepository;
	    @Autowired
	    private MongoTemplate mongoTemplate;


	    public List<Transaction> getWeeklyReport() {
	    	LocalDateTime now = LocalDateTime.now();
	        LocalDateTime weekAgo = now.minus(7, ChronoUnit.DAYS);

	        Aggregation aggregation = Aggregation.newAggregation(
	                Aggregation.match(Criteria.where("timestamp").gte(Date.from(weekAgo.atZone(ZoneId.systemDefault()).toInstant()))
	                        .lte(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))),
	                Aggregation.group("type") // Group by transaction type (debit/credit)
	                        .sum("amount").as("totalAmount")
	        );

	        AggregationResults<Transaction> results = mongoTemplate.aggregate(aggregation, "transactions", Transaction.class);
	        return results.getMappedResults();
	    }
	    
	    public List<Transaction> getMonthlyReport() {
	    	LocalDateTime now = LocalDateTime.now();
	        LocalDateTime monthAgo = now.minus(30, ChronoUnit.DAYS);

	        Aggregation aggregation = Aggregation.newAggregation(
	                Aggregation.match(Criteria.where("timestamp").gte(Date.from(monthAgo.atZone(ZoneId.systemDefault()).toInstant()))
	                        .lte(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))),
	                Aggregation.group("type") // Group by transaction type (debit/credit)
	                        .sum("amount").as("totalAmount")
	        );

	        AggregationResults<Transaction> results = mongoTemplate.aggregate(aggregation, "transactions", Transaction.class);
	        return results.getMappedResults();
	    }
	    

	    public List<Transaction> getYearlyReport() {
	    	  LocalDateTime now = LocalDateTime.now();
	          LocalDateTime yearAgo = now.minus(365, ChronoUnit.DAYS);

	          Aggregation aggregation = Aggregation.newAggregation(
	                  Aggregation.match(Criteria.where("timestamp").gte(Date.from(yearAgo.atZone(ZoneId.systemDefault()).toInstant()))
	                          .lte(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))),
	                  Aggregation.group("type") // Group by transaction type (debit/credit)
	                          .sum("amount").as("totalAmount")
	          );

	          AggregationResults<Transaction> results = mongoTemplate.aggregate(aggregation, "transactions", Transaction.class);
	          return results.getMappedResults();
	      }	    }
	


