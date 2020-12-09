package fr.training.samples.spring.shop.exposition.balance.rest;

import java.io.Serializable;

public class BalanceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String account;

    private double amount;

    /**
     * No-arg constructor for JavaBean tools
     */
    public BalanceDto() {

    }

    /**
     * @param id
     * @param account
     * @param amount
     */
     public BalanceDto(final String id, final String account, final double amount) {
        this.id = id;
        this.account = account;
        this.amount = amount;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
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


    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
