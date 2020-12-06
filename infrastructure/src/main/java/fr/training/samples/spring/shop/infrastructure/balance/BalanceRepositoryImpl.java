package fr.training.samples.spring.shop.infrastructure.balance;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class BalanceRepositoryImpl implements BalanceRepository {

    private final BalanceJpaRepository balanceJpaRepository;

    public BalanceRepositoryImpl(BalanceJpaRepository balanceJpaRepository) {
        this.balanceJpaRepository = balanceJpaRepository;
    }

    @Override
    public Balance findById(final String id){
        return balanceJpaRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public void save(Balance balance){

    }

    @Override
    public void update(Balance balance){

    }

}
