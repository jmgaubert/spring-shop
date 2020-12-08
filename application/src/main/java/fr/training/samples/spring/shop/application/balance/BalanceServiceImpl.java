package fr.training.samples.spring.shop.application.balance;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Balance findOneById(final String balanceId) {
        return balanceRepository.findById(balanceId);
    }

    @Transactional(readOnly = true)
    @Override
    public Balance findOneByBalanceAccount(final String account){
           return balanceRepository.findByBalanceAccount(account);

    }

}
