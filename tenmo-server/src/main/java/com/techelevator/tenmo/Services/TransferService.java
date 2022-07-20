//package com.techelevator.tenmo.Services;
//
//import com.techelevator.tenmo.dao.TransferDao;
//import com.techelevator.tenmo.dao.UserDao;
//import com.techelevator.tenmo.model.Transfer;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//
//@Component
//public class TransferService {
//
//
//    private final TransferDao transferDao;
//
//    public TransferService(TransferDao transferDao) {
//        this.transferDao = transferDao;
//    }
//
//    public void createTransfer(BigDecimal transferAmount, Long accountFromUserId, int accountToUserId) {
//        transferDao.createTransfer(transferAmount, accountFromUserId, accountToUserId);
//    }
//
//}
