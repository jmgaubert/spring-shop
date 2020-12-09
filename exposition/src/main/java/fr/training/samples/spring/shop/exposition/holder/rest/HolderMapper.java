package fr.training.samples.spring.shop.exposition.holder.rest;


import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.exposition.balance.rest.BalanceDto;
import fr.training.samples.spring.shop.exposition.balance.rest.BalanceLightDto;
import fr.training.samples.spring.shop.exposition.common.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Mapper for the entity Holder and its DTO HolderDtO.
 */

@Component
public class HolderMapper extends AbstractMapper<HolderDto, Holder> {

    @Override
    public HolderDto mapToDto(Holder entity) {
        final HolderDto dto = new HolderDto();
        dto.setId(entity.getId());
        dto.setAccount(entity.getAccount());
        dto.setName(entity.getName());
        dto.setMailAdress(entity.getMailAdress());
        return dto;
    }

    @Override
    public Holder mapToEntity(HolderDto dto) {
        final Holder holder = new Holder();
        holder.setId(dto.getId());
        holder.setAccount(dto.getAccount());
        holder.setName(dto.getName());
        holder.setMailAdress(dto.getMailAdress());
        return holder;
    }

    public Holder mapToEntity(@Valid final HolderLightDto dto) {
        final Holder holder = new Holder();
        holder.setAccount(dto.getAccount());
        holder.setName(dto.getName());
        holder.setMailAdress(dto.getMailAdress());
        return holder;
    }

}
