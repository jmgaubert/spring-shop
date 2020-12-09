package fr.training.samples.spring.shop.exposition.accountingmovement.rest;

import fr.training.samples.spring.shop.application.accountingmovement.AccountingMovementService;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountingMovementResource {

    private final AccountingMovementService accountingMovementService;
    private final AccountingMovementMapper accountingMovementMapper;

    /**
     * Constructor for Bean injection
     */

    public AccountingMovementResource(AccountingMovementService accountingMovementService, AccountingMovementMapper accountingMovementMapper) {
        this.accountingMovementService = accountingMovementService;
        this.accountingMovementMapper = accountingMovementMapper;
    }

    @GetMapping(value = "/accountingmovementbyid/{id}", produces = { "application/json"})
    public AccountingMovementDto getAccountingBalanceById(@PathVariable final String id){
        final AccountingMovement accountingMovement = accountingMovementService.findOneById(id);
        return accountingMovementMapper.mapToDto(accountingMovement);
    }
}
