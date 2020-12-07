package fr.training.samples.spring.shop.infrastructure.holder;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.holder.Holder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolderJpaRepository extends JpaRepository<Holder, String> {
    Holder findByAccount(String account);
}
