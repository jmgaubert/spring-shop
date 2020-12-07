package fr.training.samples.spring.shop.domain.balance;

import fr.training.samples.spring.shop.domain.customer.Customer;

public interface BalanceRepository {

    public Balance findById(String id);

    public Balance findByBalanceAccount(String account);

    public void save(Balance balance);

    public void update(Balance balance);

}
