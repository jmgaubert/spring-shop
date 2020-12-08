package fr.training.samples.spring.shop.application.tranferslip;

import fr.training.samples.spring.shop.application.order.OrderService;
import fr.training.samples.spring.shop.application.transferslip.TransferSlipService;
import fr.training.samples.spring.shop.application.transferslip.TransferSlipServiceImpl;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovementRepository;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.domain.holder.HolderRepository;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TransferSlipServiceImpl.class })
public class TranferSlipServiceImplTest {

    @Autowired
    private TransferSlipService transferSlipService;

    @MockBean
    private HolderRepository holderRepositoryMock;
    @MockBean
    private BalanceRepository balanceRepositoryMock;
    @MockBean
    private AccountingMovementRepository accountingMovementRepositoryMock;
    @MockBean
    private TransferSlipRepository transferSlipRepositoryMock;

    private TransferSlip getTransferSlip(){
        final TransferSlip transferSlip = new TransferSlip();
        transferSlip.setReference("virement 0001");
        transferSlip.setIssuerAccount("cptref00001");
        transferSlip.setReceiverAccount("cptref00002");
        transferSlip.setExecutionDate(LocalDate.of(2020,11,20));
        transferSlip.setAmount(1550.53);
        transferSlip.setLabel("virement pour anniversaire");
        transferSlip.setBeneficiaryInformation(true);
        return transferSlip;
    }

    private Holder getIssuerHolder() {
        final Holder holder = new Holder();
        holder.setAccount("cptref00001");
        holder.setName("Antoine Dupond");
        return holder;
    }

    private Holder getReceiverHolder() {
        final Holder holder = new Holder();
        holder.setAccount("cptref00002");
        holder.setName("Valérie Labelle");
        return holder;
    }

    private Balance getIssuerBalance() {
        final Balance balance = new Balance();
        balance.setAccount("cptref00001");
        balance.setAmount(3790.14);
        return balance;
    }

    private Balance getReceiverBalance() {
        final Balance balance = new Balance();
        balance.setAccount("cptref00002");
        balance.setAmount(-145.32);
        return balance;
    }

    @Test
    public void balance_after_transfer_slip_is_ok() {
        // Given
        final String referenceTransfertSlip = "virement 0001";
        when(transferSlipRepositoryMock.findById(referenceTransfertSlip)).thenReturn(getTransferSlip());

        final String issuerAccount = "cptref00001";
        final String receiverAccount = "cptref00002";
        when(holderRepositoryMock.findById(issuerAccount)).thenReturn(getIssuerHolder());
        when(holderRepositoryMock.findById(receiverAccount)).thenReturn(getReceiverHolder());
        when(balanceRepositoryMock.findById(issuerAccount)).thenReturn(getIssuerBalance());
        when(balanceRepositoryMock.findById(receiverAccount)).thenReturn(getReceiverBalance());
        // When
        final String result = transferSlipService.runOne("virement 0001");
        // Then
        assertThat(result).isEqualTo("cptref00001;2239.61:cptref00002;1405.21");
        verify(balanceRepositoryMock, times(2)).update(any());


    }

}
