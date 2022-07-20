//package com.techelevator.tenmo.dao;
//
//import com.techelevator.tenmo.model.Transfer;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.math.BigDecimal;
//
//public class JdbcTransferDao implements TransferDao {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void createTransfer(BigDecimal amount, Long accountFromId, int accountToId) {
//
//        Transfer transfer;
//        String sql = "INSERT INTO transfer VALUES (?, ?, ?)";
//
//        jdbcTemplate.update(sql, amount, accountFromId, accountToId);
//
////        try {
////            return transfer = jdbcTemplate.update(sql, amount, accountFromId, accountToId);
//////            return balance;
////        } catch (EmptyResultDataAccessException ex) {
////            return null;
////        }
//
////        return null;
//    }
//
//}
