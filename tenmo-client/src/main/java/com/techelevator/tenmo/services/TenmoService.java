package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    public void createTransfer(BigDecimal transferAmount, Long accountFromUserId, int accountToUserId) {

        try {
            Transfer transfer = restTemplate.postForObject(baseUrl + "transfer/"),

        } catch (RestClientResponseException | ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
            System.out.println(ex.getMessage());
        }


        /*
    public void createEmployee(Employee newEmployee, Integer deptId, AuthenticatedUser ussr) {
        try {
            Employee employee = restTemplate.postForObject(baseUrl + "departments/" + deptId + "/employees",
                    makeEmployeeEntity(newEmployee, ussr),
                    Employee.class);
            System.out.println("Employee saved.");
        } catch (RestClientResponseException | ResourceAccessException ex) {
            BasicLogger.log(ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }*/
    }

    public HttpEntity<Transfer> makeTransferEntity(Long accountFromUserId, int accountToUserId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(user.getToken());

        return new HttpEntity<>(accountFromUserId, accountToUserId, headers);
    }

    /*    public HttpEntity<Employee> makeEmployeeEntity(Employee employee, AuthenticatedUser user) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(user.getToken());

        return new HttpEntity<>(employee, headers);
    }*/
}
