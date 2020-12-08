package fr.training.samples.spring.shop.exposition.balance.rest;

import java.io.Serializable;

public class BalanceLightDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;

    private double amount;

    /**
     * No-arg constructor for JavaBean tools
     */
    public BalanceLightDto() {

    }

    /**
     * @param account
     * @param amount
     */
    public BalanceLightDto(final String account, final double amount) {
        this.account = account;
        this.amount = amount;
    }

    /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

}
