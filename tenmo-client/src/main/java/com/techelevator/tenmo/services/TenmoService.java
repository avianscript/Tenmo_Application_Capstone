package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public User [] displayListOfUsers () {
//         List<User> users = new ArrayList<>();
         try {
             return restTemplate.getForObject(baseUrl + "tenmoUser/", User[].class);
         } catch (RestClientResponseException | ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
