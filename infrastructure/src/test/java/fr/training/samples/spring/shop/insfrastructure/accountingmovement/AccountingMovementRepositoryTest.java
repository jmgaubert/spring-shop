package fr.training.samples.spring.shop.insfrastructure.accountingmovement;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest

public class AccountingMovementRepositoryTest {

    @Autowired
    private AccountingMovementRepository accountingMovementRepository;

    @Test
    public void existing_accounting_movement_should_be_found_by_id() {
        // Given
        final String accountingMovementId = "123e4567-e89b-42d3-a459-556642440000";

        // When

        final AccountingMovement accountingMovement = accountingMovementRepository.findById(accountingMovementId);
        // Then
        assertThat(accountingMovement.getAccount()).isEqualTo("cptref00003");
        assertThat(accountingMovement.getAmount()).isEqualTo(1503.44);
        assertThat(accountingMovement.getLabel()).isEqualTo("libellé mouvement générique");
        assertThat(accountingMovement.getOperationDate()).isEqualTo("2020-12-07");
        assertThat(accountingMovement.getReference()).isEqualTo("référence mouvement à déterminer");
        assertThat(accountingMovement.getValueDate()).isEqualTo("2020-12-06");

    }



}
