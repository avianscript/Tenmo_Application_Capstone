package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int id;
    private BigDecimal amount;
    private int accountFrom;
    private int accountTo;

    public Transfer() {

    }

    public Transfer(int id, BigDecimal amount, int accountFrom, int accountTo) {
        this.id = id;
        this.amount = amount;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(int accountFrom) {
        this.accountFrom = accountFrom;
    }

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }
}
