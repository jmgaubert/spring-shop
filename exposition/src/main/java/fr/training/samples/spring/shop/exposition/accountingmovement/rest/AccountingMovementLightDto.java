package fr.training.samples.spring.shop.exposition.accountingmovement.rest;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountingMovementLightDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String account;
    private String reference;
    private double amount;
    private LocalDate operationDate;
    private LocalDate valueDate;
    private String label;

    /**
     * No-arg constructor for JavaBean tools
     */
    public AccountingMovementLightDto() {
    }

    /**
     * @param account
     * @param reference
     * @param amount
     * @param operationDate
     * @param valueDate
     * @param label
     */

    public AccountingMovementLightDto(String account, String reference, double amount, LocalDate operationDate, LocalDate valueDate, String label) {
        this.account = account;
        this.reference = reference;
        this.amount = amount;
        this.operationDate = operationDate;
        this.valueDate = valueDate;
        this.label = label;
    }

      /**
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the operationdate
     */
    public LocalDate getOperationDate() {
        return operationDate;
    }

    /**
     * @param operationDate the operationDate to set
     */
    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    /**
     * @return the valuedate
     */
    public LocalDate getValueDate() {
        return valueDate;
    }

    /**
     * @param valueDate the valueDate to set
     */
    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }



}



