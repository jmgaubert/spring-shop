package fr.training.samples.spring.shop.insfrastructure.holder;

import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.domain.holder.HolderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HolderRepositoryTest {

    @Autowired
    private HolderRepository holderRepository;

    @Test
    public void existing_holder_should_be_found_by_id() {
        // Given
        final String holderId1 = "123e4567-e89b-42d3-a458-556642440000";
        final String holderId2 = "223e4567-e89b-42d3-a458-556642440000";
        // When
        final Holder holder1 = holderRepository.findById(holderId1);
        final Holder holder2 = holderRepository.findById(holderId2);
        // Then
        assertThat(holder1.getAccount()).isEqualTo("cptref00001");
        assertThat(holder1.getMailAdress()).isEqualTo("Antoine.Dupond@gmail.com");
        assertThat(holder1.getName()).isEqualTo("Antoine Dupond");
        assertThat(holder2.getAccount()).isEqualTo("cptref00002");
        assertThat(holder2.getMailAdress()).isEqualTo("Valérie.Labelle@gmail.com");
        assertThat(holder2.getName()).isEqualTo("Valérie Labelle");

    }

    @Test
    public void existing_holder_should_be_found_by_account() {
        // Given
        final String holderAccount1 = "cptref00001";
        final String holderAccount2 = "cptref00002";
        // When
        final Holder holder1 = holderRepository.findByHolderAccount(holderAccount1);
        final Holder holder2 = holderRepository.findByHolderAccount(holderAccount2);
        // Then
        assertThat(holder1.getId()).isEqualTo("123e4567-e89b-42d3-a458-556642440000");
        assertThat(holder1.getAccount()).isEqualTo("cptref00001");
        assertThat(holder1.getMailAdress()).isEqualTo("Antoine.Dupond@gmail.com");
        assertThat(holder1.getName()).isEqualTo("Antoine Dupond");
        assertThat(holder2.getId()).isEqualTo("223e4567-e89b-42d3-a458-556642440000");
        assertThat(holder2.getAccount()).isEqualTo("cptref00002");
        assertThat(holder2.getMailAdress()).isEqualTo("Valérie.Labelle@gmail.com");
        assertThat(holder2.getName()).isEqualTo("Valérie Labelle");

    }


}
