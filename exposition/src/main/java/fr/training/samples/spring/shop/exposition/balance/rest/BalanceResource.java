package fr.training.samples.spring.shop.exposition.balance.rest;

import fr.training.samples.spring.shop.application.balance.BalanceService;
import fr.training.samples.spring.shop.domain.balance.Balance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
