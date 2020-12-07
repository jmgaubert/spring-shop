package fr.training.samples.spring.shop.insfrastructure.balance;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BalanceRepositoryTest {

    @Autowired
    private BalanceRepository balanceRepository;

    @Test
    public void existing_balance_should_be_found_by_id() {
        // Given
        final String balanceId1 = "123e4567-e89b-42d3-a457-556642440000";
        final String balanceId2 = "223e4567-e89b-42d3-a457-556642440000";
        // When
        final Balance balance1 = balanceRepository.findById(balanceId1);
        final Balance balance2 = balanceRepository.findById(balanceId2);
        // Then
        assertThat(balance1.getAccount()).isEqualTo("cptref00001");
        assertThat(balance1.getAmount()).isEqualTo(3790.14);
        assertThat(balance2.getAccount()).isEqualTo("cptref00002");
        assertThat(balance2.getAmount()).isEqualTo(-145.32);

    }
    @Test
    public void existing_balance_should_be_found_by_account() {
        // Given
        final String balanceAccount1 = "cptref00001";
        final String balanceAccount2 = "cptref00002";
        // When
        final Balance balance1 = balanceRepository.findByBalanceAccount(balanceAccount1);
        final Balance balance2 = balanceRepository.findByBalanceAccount(balanceAccount2);
        // Then
        assertThat(balance1.getId()).isEqualTo("123e4567-e89b-42d3-a457-556642440000");
        assertThat(balance1.getAccount()).isEqualTo("cptref00001");
        assertThat(balance1.getAmount()).isEqualTo(3790.14);
        assertThat(balance2.getId()).isEqualTo("223e4567-e89b-42d3-a457-556642440000");
        assertThat(balance2.getAccount()).isEqualTo("cptref00002");
        assertThat(balance2.getAmount()).isEqualTo(-145.32);

    }



}
