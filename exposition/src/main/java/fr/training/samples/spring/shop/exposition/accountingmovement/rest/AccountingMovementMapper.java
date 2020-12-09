package fr.training.samples.spring.shop.exposition.accountingmovement.rest;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.exposition.balance.rest.BalanceDto;
import fr.training.samples.spring.shop.exposition.common.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Mapper for the entity AccountingMovement and its DTO AccountingMovementDto.
 */
@Component
//public class AccountingMovementMapper extends AbstractMapper<AccountingMovementDto, AccountingMovement> {
    public class AccountingMovementMapper extends AbstractMapper<AccountingMovementDto, AccountingMovement> {
    @Override
    public AccountingMovementDto mapToDto(final AccountingMovement entity){
        final AccountingMovementDto dto = new AccountingMovementDto();
        dto.setId(entity.getId());
        dto.setAccount(entity.getAccount());
        dto.setAmount(entity.getAmount());
        dto.setOperationDate(entity.getOperationDate());
        dto.setValueDate(entity.getValueDate());
        dto.setLabel(entity.getLabel());
        dto.setReference(entity.getReference());
        return dto;

    }

    @Override
    public AccountingMovement mapToEntity(final AccountingMovementDto dto){
        final AccountingMovement accountingMovement = new AccountingMovement();
        accountingMovement.setId(dto.getId());
        accountingMovement.setAccount(dto.getAccount());
        accountingMovement.setAmount(dto.getAmount());
        accountingMovement.setOperationDate(dto.getOperationDate());
        accountingMovement.setValueDate(dto.getValueDate());
        accountingMovement.setLabel(dto.getLabel());
        accountingMovement.setReference(dto.getReference());
        return accountingMovement;

    }

    public AccountingMovement mapToEntity(@Valid final AccountingMovementLightDto dto){
        final AccountingMovement accountingMovement = new AccountingMovement();
        accountingMovement.setAccount(dto.getAccount());
        accountingMovement.setAmount(dto.getAmount());
        accountingMovement.setOperationDate(dto.getOperationDate());
        accountingMovement.setValueDate(dto.getValueDate());
        accountingMovement.setLabel(dto.getLabel());
        accountingMovement.setReference(dto.getReference());
        return accountingMovement;

    }






}
