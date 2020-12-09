package fr.training.samples.spring.shop.application.holder;


import fr.training.samples.spring.shop.application.accountingmovement.AccountingMovementServiceImpl;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.domain.holder.HolderRepository;
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
@SpringBootTest(classes = { HolderServiceImpl.class })
public class HolderServiceImplTest {

    @Autowired
    private HolderService holderService;

    @MockBean
    private HolderRepository holderRepositoryMock;

    private Holder getHolder(){
        final Holder holder = new Holder();

        holder.setId("123e4567-e89b-42d3-a458-556642440000");
        holder.setAccount("cptref00001");
        holder.setName("Antoine dupond");
        holder.setMailAdress("Antoine.Dupond@gmail.com");
        return holder;

    }

    @Test
    public void holder_findOne_should_call_findById_repository_is_ok() {
        // Given
        final String holderId = "123e4567-e89b-42d3-a458-556642440000";
        when(holderRepositoryMock.findById(holderId)).thenReturn(getHolder());
        // When
        final Holder result = holderService.findOneById(holderId);
        // Then
        assertThat(result.getAccount()).isEqualTo("cptref00001");
        assertThat(result.getName()).isEqualTo("Antoine dupond");
        assertThat(result.getMailAdress()).isEqualTo("Antoine.Dupond@gmail.com");

    }


    @Test
    public void holder_save_is_ok() {
        // Given
        final Holder holder = new Holder();
        holder.setId("123e4567-e89b-42d3-a558-556642440000");
        holder.setAccount("cptref00005");
        holder.setName("Jade Bretagne");
        holder.setMailAdress("Jade.Bretagne@gmail.com");

        // When
        final Holder result = holderService.addHolder(holder);
        // Then

        assertThat(result.getName()).isEqualTo("Jade Bretagne");
        assertThat(result.getMailAdress()).isEqualTo("Jade.Bretagne@gmail.com");

    }

}
