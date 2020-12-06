package fr.training.samples.spring.shop.domain.accountingmovement;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class AccountingMovement extends AbstractBaseEntity {

    private String account;
    private String reference;
    private double amount;
    private LocalDate operationDate;
    private LocalDate valueDate;
    private String label;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

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
