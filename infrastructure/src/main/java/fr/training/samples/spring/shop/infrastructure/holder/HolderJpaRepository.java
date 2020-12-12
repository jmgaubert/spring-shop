package fr.training.samples.spring.shop.infrastructure.holder;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.holder.Holder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HolderJpaRepository extends JpaRepository<Holder, String> {

    @Query(value = "SELECT * FROM HOLDER WHERE ACCOUNT = ?", nativeQuery = true)
    Holder findByAccount(String account);
}
