package fr.training.samples.spring.shop.application.balance;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.customer.Customer;

public interface BalanceService {

    /**
     * Retrieve a balance according to the given identifier.
     *
     * @param balanceId the balance identifier
     * @return the retrieved Balance
     */
    public Balance findOneById(String balanceId);

    /**
     * Retrieve a balance according to the given identifier.
     *
     * @param account the balance identifier
     * @return the retrieved Balance
     */
    public Balance findOneByBalanceAccount(String account);
}
