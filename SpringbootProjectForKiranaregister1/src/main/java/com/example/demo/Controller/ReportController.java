package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Transaction;
import com.example.demo.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

	    @Autowired
	    private  ReportService  reportService;

	    @GetMapping("/weekly")
	    public List<Transaction> getWeeklyReport() {
	        return reportService.getWeeklyReport();
	    }

	    
	    @GetMapping("/monthly")
	    public List<Transaction> getMonthlyReport() {
	        return reportService.getMonthlyReport();
	    }

	    @GetMapping("/yearly")
	    public List<Transaction> getYearlyReport() {
	        return reportService.getYearlyReport();
	    }
	}

