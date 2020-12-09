package fr.training.samples.spring.shop.exposition.balance.rest;

import fr.training.samples.spring.shop.application.balance.BalanceService;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementLightDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class BalanceResource {

    private final BalanceService balanceService;
    private final BalanceMapper balanceEntityMapper;

    /**
     * Constructor for Bean injection
     */
        public BalanceResource(BalanceService balanceService, BalanceMapper balanceEntityMapper) {
        this.balanceService = balanceService;
        this.balanceEntityMapper = balanceEntityMapper;
    }


    @GetMapping(value = "/balancebyid/{id}", produces = { "application/json"})
    public BalanceDto getBalanceById(@PathVariable final String id){
            final Balance balance = balanceService.findOneById(id);
            return balanceEntityMapper.mapToDto(balance);
    }

    @GetMapping(value = "/balancebyaccount/{account}", produces = { "application/json"})
    public BalanceDto getBalanceByAccount(@PathVariable final String account){
        final Balance balance = balanceService.findOneByBalanceAccount(account);
        return balanceEntityMapper.mapToDto(balance);
    }

    @PostMapping(value = "/balancepost", produces = { "application/json" })
    public ResponseEntity<URI> addBalanceUsingPost(@Valid @RequestBody final BalanceLightDto balanceDto ){
        final Balance balance = balanceEntityMapper.mapToEntity(balanceDto);
        balanceService.addBalance(balance);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(balance.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping(value = "/balanceput", produces = { "application/json" })
    public ResponseEntity<URI> addBalanceUsingPut(@Valid @RequestBody final BalanceDto balanceDto ){
        final Balance balance = balanceEntityMapper.mapToEntity(balanceDto);
        balanceService.updateBalance(balance);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(balance.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

}
