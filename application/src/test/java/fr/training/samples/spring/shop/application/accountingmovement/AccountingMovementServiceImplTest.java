package fr.training.samples.spring.shop.application.accountingmovement;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovementRepository;
import fr.training.samples.spring.shop.domain.balance.Balance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { AccountingMovementServiceImpl.class })
public class AccountingMovementServiceImplTest {

    @Autowired
    private AccountingMovementService accountingMovementService;

    @MockBean
    private AccountingMovementRepository AccountingMovementRepositoryMock;

    private AccountingMovement getAccountingMovement() {
        final AccountingMovement accountingMovement = new AccountingMovement();

        accountingMovement.setId("123e4567-e89b-42d3-a459-556642440000");
        accountingMovement.setAccount("cptref00003");
        accountingMovement.setAmount(1503.44);
        accountingMovement.setLabel("libellé mouvement générique");
        accountingMovement.setOperationDate(LocalDate.of(2020,12,07));
        accountingMovement.setReference("référence mouvement à déterminer");
        accountingMovement.setValueDate(LocalDate.of(2020,12,06));
        return accountingMovement;
    }
    @Test
    public void accounting_movement_findOne_should_call_findById_repository_is_ok() {
        // Given
        final String accountingMovementId = "123e4567-e89b-42d3-a459-556642440000";
        when(AccountingMovementRepositoryMock.findById(accountingMovementId)).thenReturn(getAccountingMovement());
        // When
        final AccountingMovement result = accountingMovementService.findOneById(accountingMovementId);
        // Then
        assertThat(result.getAmount()).isEqualTo(1503.44);
        assertThat(result.getOperationDate()).isEqualTo(LocalDate.of(2020,12,07));
    }

    @Test
    public void accounting_movement_save_is_ok() {
        // Given
        final AccountingMovement accountingMovement = new AccountingMovement();
        accountingMovement.setId("123e4567-e89b-42d3-a460-556642440000");
        accountingMovement.setAccount("cptref00004");
        accountingMovement.setAmount(121215.44);
        accountingMovement.setLabel("libellé mouvement générique");
        accountingMovement.setOperationDate(LocalDate.of(2020,12,15));
        accountingMovement.setReference("référence mouvement à déterminer");
        accountingMovement.setValueDate(LocalDate.of(2020,12,07));

        // When
        final AccountingMovement result = accountingMovementService.addAccountingMovement(accountingMovement);
        // Then

        assertThat(result.getAmount()).isEqualTo(121215.44);
        assertThat(result.getOperationDate()).isEqualTo(LocalDate.of(2020,12,15));

    }


}
