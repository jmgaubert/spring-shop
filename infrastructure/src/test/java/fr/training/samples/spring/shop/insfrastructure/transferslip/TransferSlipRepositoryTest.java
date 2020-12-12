package fr.training.samples.spring.shop.insfrastructure.transferslip;

import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TransferSlipRepositoryTest {
    @Autowired
    private TransferSlipRepository transferSlipRepository;

    @Test
    public void existing_sliptranfer_should_be_found_by_id() {
        // Given
        final String transferSlipId = "323e4567-e90b-42d3-a456-556642440000";

        // When
        final TransferSlip transferSlip = transferSlipRepository.findById(transferSlipId);

        // Then
        assertThat(transferSlip.getId()).isEqualTo("323e4567-e90b-42d3-a456-556642440000");
        assertThat(transferSlip.getReference()).isEqualTo("bordereau transfert test");
        assertThat(transferSlip.getIssuerAccount()).isEqualTo("cptref0007");
        assertThat(transferSlip.getReceiverAccount()).isEqualTo("cptref0008");
        assertThat(transferSlip.getExecutionDate()).isEqualTo("2020-12-11");
        assertThat(transferSlip.getAmount()).isEqualTo(2354.42);
        assertThat(transferSlip.getLabel()).isEqualTo("virement pour anniversaire");
        assertThat(transferSlip.getBeneficiaryInformation()).isEqualTo(true);

    }

}
