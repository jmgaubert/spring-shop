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

    /**
     * balance according to be save.
     *
     * @param balance the balance
     * @return the balance
     */
    public Balance updateBalance(Balance balance);

    /**
     * balance according to be update.
     *
     * @param balance the balance
     * @return the balance
     */
    public Balance addBalance(Balance balance);


}
