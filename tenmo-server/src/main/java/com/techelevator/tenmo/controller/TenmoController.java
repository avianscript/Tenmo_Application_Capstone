package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.Services.AccountService;
//import com.techelevator.tenmo.Services.TransferService;
import com.techelevator.tenmo.Services.UserService;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TenmoController {

    private final UserService userService;
    private final AccountService accountService;
//    private final TransferService transferService;
//     public TenmoController(UserService userService, AccountService accountService, TransferService transferService)
    public TenmoController(UserService userService, AccountService accountService)  {
        this.userService = userService;
        this.accountService = accountService;
//        this.transferService = transferService;
    }

    @GetMapping("account/{id}")
    public BigDecimal getBalance(@PathVariable Long id) {
        return accountService.getBalance(id);
    }

    @GetMapping("tenmoUser/")
    public User[] displayListOfUsers() {
        return userService.displayListOfUsers();
    }

//    @GetMapping("transfer/")
//    public void createTransfer() {
//        transferService.createTransfer();
//    }

}
