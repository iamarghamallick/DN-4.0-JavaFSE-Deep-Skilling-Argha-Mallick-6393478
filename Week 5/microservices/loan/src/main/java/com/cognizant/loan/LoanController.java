package com.cognizant.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class LoanController {

    @GetMapping("/loans/{accountNumber}")
    public Map<String, Object> getLoanDetails(@PathVariable String accountNumber) {
        Map<String, Object> getLoanDetails = new LinkedHashMap<>();

        getLoanDetails.put("accountNumber", accountNumber);
        getLoanDetails.put("type", "car");
        getLoanDetails.put("loan", 400000);
        getLoanDetails.put("emi", 3258);
        getLoanDetails.put("tenure", 18);

        return getLoanDetails;
    }
}
