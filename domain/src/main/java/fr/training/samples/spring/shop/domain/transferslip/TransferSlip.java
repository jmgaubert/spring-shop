package fr.training.samples.spring.shop.domain.transferslip;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class TransferSlip extends AbstractBaseEntity {

    private String reference;
    private String issuerAccount;
    private String receiverAccount;
    private LocalDate executionDate;
    private double amount;
    private String label;
    private boolean beneficiaryInformation;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getIssuerAccount() {
        return issuerAccount;
    }

    public void setIssuerAccount(String issuerAccount) {
        this.issuerAccount = issuerAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean getBeneficiaryInformation() {
        return beneficiaryInformation;
    }

    public void setBeneficiaryInformation(boolean beneficiaryInformation) {
        this.beneficiaryInformation = beneficiaryInformation;
    }

    /**
     * @return the id
     */
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public void setId(String id) {
        super.setId(id);
    }

    @Override
    public Integer getVersion() {
        return super.getVersion();
    }

    @Override
    public void setVersion(Integer version) {
        super.setVersion(version);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
