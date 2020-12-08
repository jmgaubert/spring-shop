package fr.training.samples.spring.shop.exposition.balance.rest;


import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.exposition.common.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Mapper for the entity Balance and its DTO BalanceDtO.
 */
@Component
public class BalanceMapper extends AbstractMapper<BalanceDto, Balance> {

    @Override
    public BalanceDto mapToDto(final Balance entity) {
        final BalanceDto dto = new BalanceDto();
        dto.setId(entity.getId());
        dto.setAccount(entity.getAccount());
        dto.setAmount(entity.getAmount());
        return dto;
    }

    @Override
    public Balance mapToEntity(final BalanceDto dto) {
        final Balance balance = new Balance();
        balance.setId(dto.getId());
        balance.setAccount(dto.getAccount());
        balance.setAmount(dto.getAmount());
        return balance;
    }

    public Balance mapToEntity(@Valid final BalanceLightDto dto) {
        final Balance balance = new Balance();
        balance.setAccount(dto.getAccount());
        balance.setAmount(dto.getAmount());
        return balance;
    }

}
