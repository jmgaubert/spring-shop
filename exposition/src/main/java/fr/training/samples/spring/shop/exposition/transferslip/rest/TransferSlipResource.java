package fr.training.samples.spring.shop.exposition.transferslip.rest;

import fr.training.samples.spring.shop.application.accountingmovement.AccountingMovementService;
import fr.training.samples.spring.shop.application.transferslip.TransferSlipService;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementDto;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementLightDto;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class TransferSlipResource {

    private final TransferSlipService transferSlipService;
    private final TransferSlipMapper transferSlipMapper;

    /**
     * Constructor for Bean injection
     */

    public TransferSlipResource(TransferSlipService transferSlipService, TransferSlipMapper transferSlipMapper) {
        this.transferSlipService = transferSlipService;
        this.transferSlipMapper = transferSlipMapper;
    }

    @GetMapping(value = "/transferslipbyid/{id}", produces = { "application/json"})
    public TransferSlipDto getTransferSlipById(@PathVariable final String id){
        final TransferSlip transferSlip = transferSlipService.findOne(id);
        return transferSlipMapper.mapToDto(transferSlip);
    }

    @PostMapping(value = "/transferslippost", produces = { "application/json" })
    public ResponseEntity<URI> addTransferSlipUsingPost(@Valid @RequestBody final TransferSlipDto transferSlipDto ){
        final TransferSlip transferSlip = transferSlipMapper.mapToEntity(transferSlipDto);
        transferSlipService.create(transferSlip);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transferSlip.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

}
