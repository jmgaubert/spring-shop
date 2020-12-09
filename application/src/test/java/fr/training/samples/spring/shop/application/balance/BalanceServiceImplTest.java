package fr.training.samples.spring.shop.application.balance;

import fr.training.samples.spring.shop.application.transferslip.TransferSlipService;
import fr.training.samples.spring.shop.application.transferslip.TransferSlipServiceImpl;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BalanceServiceImpl.class })
public class BalanceServiceImplTest {

    @Autowired
    private BalanceService balanceService;

    @MockBean
    private BalanceRepository balanceRepositoryMock;

    private Balance getBalance() {
        final Balance balance = new Balance();
        balance.setId("123e4567-e89b-42d3-a457-556642440000");
        balance.setAccount("cptref00001");
        balance.setAmount(3790.14);
        return balance;
    }
    @Test
    public void balance_findOne_should_call_findById_repository_is_ok() {
        // Given
        final String balanceId = "123e4567-e89b-42d3-a457-556642440000";
        when(balanceRepositoryMock.findById(balanceId)).thenReturn(getBalance());
        // When
        final Balance result = balanceService.findOneById(balanceId);
        // Then
        assertThat(result.getAmount()).isEqualTo(3790.14);
    }

    @Test
    public void balance_update_is_ok(){
        // Given
        final String balanceId = "123e4567-e89b-42d3-a457-556642440000";
        when(balanceRepositoryMock.findById(balanceId)).thenReturn(getBalance());
        // When
        final Balance result = balanceService.findOneById(balanceId);
        result.setAmount(12345.67);
        final Balance resultUpdate = balanceService.updateBalance(result);
        // Then
        assertThat(resultUpdate.getAmount()).isEqualTo(12345.67);
    }
}
