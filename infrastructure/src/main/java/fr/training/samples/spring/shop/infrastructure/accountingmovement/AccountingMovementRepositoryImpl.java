package fr.training.samples.spring.shop.infrastructure.accountingmovement;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovementRepository;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.customer.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class AccountingMovementRepositoryImpl implements AccountingMovementRepository {

    private final AccountingMovementJpaRepository accountingMovementJpaRepository;

    public AccountingMovementRepositoryImpl(AccountingMovementJpaRepository accountingMovementJpaRepository) {
        this.accountingMovementJpaRepository = accountingMovementJpaRepository;
    }

    @Override
    public AccountingMovement findById(final String id){
        return accountingMovementJpaRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void save(final AccountingMovement accountingMovement) {
        accountingMovementJpaRepository.save(accountingMovement);
    }

}
