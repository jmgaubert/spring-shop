package fr.training.samples.spring.shop.exposition.holder.rest;

import fr.training.samples.spring.shop.application.holder.HolderService;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.exposition.accountingmovement.rest.AccountingMovementLightDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class HolderResource {

    private final HolderService holderService;
    private final HolderMapper holderMapper;

    /**
     * Constructor for Bean injection
     */

    public HolderResource(HolderService holderService, HolderMapper holderMapper) {
        this.holderService = holderService;
        this.holderMapper = holderMapper;
    }

    @GetMapping(value = "/holderbyid/{id}", produces = { "application/json"})
    public HolderDto getHolderById(@PathVariable final String id){
        final Holder holder = holderService.findOneById(id);
        return holderMapper.mapToDto(holder);

    }

    @PostMapping(value = "/holder", produces = { "application/json" })
    public ResponseEntity<URI> addHolderUsingPost(@Valid @RequestBody final HolderLightDto holderDto ){
        final Holder holder = holderMapper.mapToEntity(holderDto);
        holderService.addHolder(holder);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(holder.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

}
