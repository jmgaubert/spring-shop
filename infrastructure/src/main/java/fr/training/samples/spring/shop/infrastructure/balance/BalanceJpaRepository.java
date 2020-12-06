package fr.training.samples.spring.shop.infrastructure.balance;

import fr.training.samples.spring.shop.domain.balance.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceJpaRepository extends JpaRepository<Balance, String> {
}
