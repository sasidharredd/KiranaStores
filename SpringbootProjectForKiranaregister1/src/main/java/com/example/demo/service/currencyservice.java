package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class currencyservice {
	    private static final String FX_API_URL = "https://api.fxratesapi.com/latest?base=INR";

	    @Cacheable("fxRates")
	    public double convertCurrency(String currency, double amount) {
	        RestTemplate restTemplate = new RestTemplate();
	        Map<String, Object> response = restTemplate.getForObject(FX_API_URL, Map.class);

	        if (response == null || !response.containsKey("rates")) {
	            throw new RuntimeException("Currency conversion failed.");
	        }

	        Map<String, Double> rates = (Map<String, Double>) response.get("rates");
	        double rate = rates.getOrDefault(currency, 84.00);
	        return amount * rate;
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	BigDecimal CurrencyINR;
//	@Autowired
//	Transaction trans;
//
////	@Cacheable("currencyRates")
////    public Map<String, Double> getConversionRates() {
////        // Call fxratesapi.com using RestTemplate or FeignClient
////        // Parse and return conversion rates
////    }
////
////	public double convertAmount(double amount, String fromCurrency, String toCurrency) {
////        // Logic to convert using the cached conversion rates
////    }
//private static final String API_URL = "https://api.fxratesapi.com/latest?base=INR";
//
//@Cacheable("currencyrates")
//    public BigDecimal convertCurrency(BigDecimal amount, String currency) {
//        // Call external API and handle response here
//        // Mock conversion for demo
//    	if(trans.getType().toUpperCase()=="USD") {
//       CurrencyINR= amount.multiply(BigDecimal.valueOf(84)); // Assume 1 currency unit = 80 INR
//    		
//    }
//    	else {
//    		   CurrencyINR= amount;
//    	}
//    	 return CurrencyINR;
//}

