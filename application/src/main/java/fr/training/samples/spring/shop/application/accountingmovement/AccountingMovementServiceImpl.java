package fr.training.samples.spring.shop.application.accountingmovement;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovementRepository;
import org.springframework.transaction.annotation.Transactional;

public class AccountingMovementServiceImpl implements AccountingMovementService {

    private final AccountingMovementRepository accountingMovementRepository;

    public AccountingMovementServiceImpl(AccountingMovementRepository accountingMovementRepository) {
        this.accountingMovementRepository = accountingMovementRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public AccountingMovement findOneById(final String accountingMovementId) {
        return accountingMovementRepository.findById(accountingMovementId);
    }

    @Transactional
    @Override
    public AccountingMovement addAccountingMovement(final AccountingMovement accountingMovement){
        accountingMovementRepository.save(accountingMovement);
        return accountingMovement;

    }

}
