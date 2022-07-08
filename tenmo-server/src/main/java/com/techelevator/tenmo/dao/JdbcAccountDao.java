package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public BigDecimal findBalance(Long id) {
        BigDecimal balance;
        String sql = "SELECT balance FROM account WHERE user_id = ?";

        try {
            balance = jdbcTemplate.queryForObject(sql, BigDecimal.class, id);
            return balance;
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }
}
