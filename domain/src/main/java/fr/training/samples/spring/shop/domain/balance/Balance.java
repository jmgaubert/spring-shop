package fr.training.samples.spring.shop.domain.balance;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;

import javax.persistence.Entity;

@Entity
public class Balance extends AbstractBaseEntity {
    private String account;
    private Double amount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
