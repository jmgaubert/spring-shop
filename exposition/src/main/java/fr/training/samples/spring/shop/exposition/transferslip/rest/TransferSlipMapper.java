package fr.training.samples.spring.shop.exposition.transferslip.rest;


import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementDto;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementLightDto;
import fr.training.samples.spring.shop.exposition.common.AbstractMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Mapper for the entity TransferSlip and its DTO TransferSlipDto.
 */
@Component
public class TransferSlipMapper extends AbstractMapper<TransferSlipDto, TransferSlip> {
    @Override
    public TransferSlipDto mapToDto(final TransferSlip entity){
        final TransferSlipDto dto = new TransferSlipDto();
        dto.setId(entity.getId());
        dto.setReference(entity.getReference());
        dto.setIssuerAccount(entity.getIssuerAccount());
        dto.setReceiverAccount(entity.getReceiverAccount());
        dto.setAmount(entity.getAmount());
        dto.setExecutionDate(entity.getExecutionDate());
        dto.setLabel(entity.getLabel());
        dto.setBeneficiaryInformation(entity.getBeneficiaryInformation());
        return dto;

    }

    @Override
    public TransferSlip mapToEntity(final TransferSlipDto dto){
        final TransferSlip transferSlip = new TransferSlip();
        transferSlip.setId(dto.getId());
        transferSlip.setReference(dto.getReference());
        transferSlip.setIssuerAccount(dto.getIssuerAccount());
        transferSlip.setReceiverAccount(dto.getReceiverAccount());
        transferSlip.setAmount(dto.getAmount());
        transferSlip.setExecutionDate(dto.getExecutionDate());
        transferSlip.setLabel(dto.getLabel());
        transferSlip.setBeneficiaryInformation(dto.getBeneficiaryInformation());
        return transferSlip;

    }

    public TransferSlip mapToEntity(@Valid final TransferSlipLightDto dto){
        final TransferSlip transferSlip = new TransferSlip();
        transferSlip.setReference(dto.getReference());
        transferSlip.setIssuerAccount(dto.getIssuerAccount());
        transferSlip.setReceiverAccount(dto.getReceiverAccount());
        transferSlip.setAmount(dto.getAmount());
        transferSlip.setExecutionDate(dto.getExecutionDate());
        transferSlip.setLabel(dto.getLabel());
        transferSlip.setBeneficiaryInformation(dto.getBeneficiaryInformation());
        return transferSlip;

    }


}
