package com.techelevator.tenmo.Services;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.UserDao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public BigDecimal getBalance(Long id) {
        return accountDao.findBalance(id);
    }
}
