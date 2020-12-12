package fr.training.samples.spring.shop.exposition.transferslip.rest;

import java.io.Serializable;
import java.time.LocalDate;

public class TransferSlipLightDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String reference;
    private String issuerAccount;
    private String receiverAccount;
    private LocalDate executionDate;
    private double amount;
    private String label;
    private boolean beneficiaryInformation;

    /**
     * No-arg constructor for JavaBean tools
     */
    public TransferSlipLightDto() {
    }

    /**
     * @param reference
     * @param issuerAccount
     * @param receiverAccount
     * @param executionDate
     * @param amount
     * @param label
     * @param beneficiaryInformation
     */
    public TransferSlipLightDto(String reference, String issuerAccount, String receiverAccount, LocalDate executionDate, double amount, String label, boolean beneficiaryInformation) {
        this.reference = reference;
        this.issuerAccount = issuerAccount;
        this.receiverAccount = receiverAccount;
        this.executionDate = executionDate;
        this.amount = amount;
        this.label = label;
        this.beneficiaryInformation = beneficiaryInformation;
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
     * @return the issuerAccount
     */
    public String getIssuerAccount() {
        return issuerAccount;
    }

    /**
     * @param issuerAccount the issuerAccount to set
     */
    public void setIssuerAccount(String issuerAccount) {
        this.issuerAccount = issuerAccount;
    }

    /**
     * @return the receiverAccount
     */
    public String getReceiverAccount() {
        return receiverAccount;
    }

    /**
     * @param receiverAccount the receiverAccount to set
     */
    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    /**
     * @return the executionDate
     */
    public LocalDate getExecutionDate() {
        return executionDate;
    }

    /**
     * @param executionDate the executionDate to set
     */
    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
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

     /**
     * @param beneficiaryInformation the beneficiaryInformation to set
     */
    public void setBeneficiaryInformation(boolean beneficiaryInformation) {
        this.beneficiaryInformation = beneficiaryInformation;
    }
    /**
     * @return the beneficiaryInformation
     */
    public boolean getBeneficiaryInformation() {
        return beneficiaryInformation;
    }

}
