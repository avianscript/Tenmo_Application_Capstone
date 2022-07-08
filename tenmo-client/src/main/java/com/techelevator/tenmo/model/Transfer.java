package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfer {

    private int id;
    private BigDecimal amount;

    private int accountTo;
    private int getAccountFrom;

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

    public int getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(int accountTo) {
        this.accountTo = accountTo;
    }

    public int getGetAccountFrom() {
        return getAccountFrom;
    }

    public void setGetAccountFrom(int getAccountFrom) {
        this.getAccountFrom = getAccountFrom;
    }
}
