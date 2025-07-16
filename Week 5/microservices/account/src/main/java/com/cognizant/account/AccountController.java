package com.cognizant.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class AccountController {

    @GetMapping("/accounts/{accountNumber}")
    public Map<String, Object> getAccountDetails(@PathVariable String accountNumber) {
        Map<String, Object> accountDetails = new LinkedHashMap<>();

        accountDetails.put("accountNumber", accountNumber);
        accountDetails.put("type", "savings");
        accountDetails.put("balance", 123456);

        return accountDetails;
    }
}
