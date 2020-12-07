package fr.training.samples.spring.shop.infrastructure.accountingmovement;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.balance.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountingMovementJpaRepository extends JpaRepository<AccountingMovement, String> {
}
