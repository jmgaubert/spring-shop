package fr.training.samples.spring.shop.infrastructure.holder;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.domain.holder.HolderRepository;
import fr.training.samples.spring.shop.infrastructure.balance.BalanceJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HolderRepositoryImpl implements HolderRepository {

    private final HolderJpaRepository holderJpaRepository;

    public HolderRepositoryImpl(HolderJpaRepository holderJpaRepository) {
        this.holderJpaRepository = holderJpaRepository;
    }
    @Override
    public Holder findById(final String id){
        return holderJpaRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Holder findByHolderAccount(final String account){
        return holderJpaRepository.findByAccount(account);
    }

    @Override
    public void save(final Holder holder) {
        holderJpaRepository.save(holder);

    }

    @Override
    public void update(Holder holder) {

    }
}
