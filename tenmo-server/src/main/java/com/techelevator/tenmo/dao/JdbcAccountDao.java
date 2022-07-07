package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;

public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account findBalance() {
        BigDecimal balance;
        String sql = "SELECT balance FROM account WHERE user_id = ?";

        try {
            balance = jdbcTemplate.query
//            Long id = jdbcTemplate.queryForObject(sql, Long.class, username);
            return balance;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }
}
