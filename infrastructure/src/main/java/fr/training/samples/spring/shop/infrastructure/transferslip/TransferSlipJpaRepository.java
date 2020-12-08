package fr.training.samples.spring.shop.infrastructure.transferslip;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferSlipJpaRepository extends JpaRepository<TransferSlip, String> {
}
