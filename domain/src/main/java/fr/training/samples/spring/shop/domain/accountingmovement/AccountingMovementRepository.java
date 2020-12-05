package fr.training.samples.spring.shop.domain.accountingmovement;

import fr.training.samples.spring.shop.domain.balance.Balance;

public interface AccountingMovementRepository {

    public AccountingMovement findById(String id);

    public void save(AccountingMovement accountingMovement);

}
