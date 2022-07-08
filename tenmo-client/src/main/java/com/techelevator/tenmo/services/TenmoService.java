package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TenmoService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public TenmoService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public BigDecimal getCurrentBalance(Long id) {
        try {
            return restTemplate.getForObject(baseUrl + "account/" + id, BigDecimal.class);
        } catch (RestClientResponseException | ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
