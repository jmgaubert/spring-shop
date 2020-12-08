package fr.training.samples.spring.shop.application.accountingmovement;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.balance.Balance;

public interface AccountingMovementService {

    /**
     * Retrieve a accountingmovement according to the given identifier.
     *
     * @param accountingId the accountingmovement identifier
     * @return the retrieved Balance
     */
    public AccountingMovement findOneById(String accountingId);

    /**
     * Retrieve a accountingmovement according to be save.
     *
     * @param accountingMovement the accountingmovement
     * @return the accountingmovement
     */
    public AccountingMovement addAccountingMovement(AccountingMovement accountingMovement);

}
