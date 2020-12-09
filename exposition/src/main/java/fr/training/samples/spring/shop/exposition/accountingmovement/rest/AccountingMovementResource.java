package fr.training.samples.spring.shop.exposition.accountingmovement.rest;

import com.sun.jndi.toolkit.url.Uri;
import fr.training.samples.spring.shop.application.accountingmovement.AccountingMovementService;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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

    @PostMapping(value = "/accountingmovement", produces = { "application/json" })
    public ResponseEntity<URI> addAccountingMovementUsingPost(@Valid @RequestBody final AccountingMovementLightDto accountingMovementDto ){
        final AccountingMovement accountingMovement = accountingMovementMapper.mapToEntity(accountingMovementDto);
        accountingMovementService.addAccountingMovement(accountingMovement);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountingMovement.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
