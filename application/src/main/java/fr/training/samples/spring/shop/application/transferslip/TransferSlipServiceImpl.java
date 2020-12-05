package fr.training.samples.spring.shop.application.transferslip;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovementRepository;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.balance.BalanceRepository;
import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.domain.holder.HolderRepository;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlipRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferSlipServiceImpl implements TransferSlipService {

    private final HolderRepository holderRepository;
    private final BalanceRepository balanceRepository;
    private final AccountingMovementRepository accountingMovementRepository;
    private final TransferSlipRepository transferSlipRepository;

    public TransferSlipServiceImpl(HolderRepository holderRepository, BalanceRepository balanceRepository, AccountingMovementRepository accountingMovementRepository, TransferSlipRepository transferSlipRepository) {
        this.holderRepository = holderRepository;
        this.balanceRepository = balanceRepository;
        this.accountingMovementRepository = accountingMovementRepository;
        this.transferSlipRepository = transferSlipRepository;
    }



    @Override
    public TransferSlip create(TransferSlip transferSlip) {
        return null;
    }

    @Override
    public TransferSlip findOne(String transferSlipId) {
        return null;
    }

    @Override
    public String runOne(String transferSlipId) {
        TransferSlip transferSlip = transferSlipRepository.findById(transferSlipId);
        //implémenter un find par account dans les repository
        //dans Holder il faut impmlémenter comme recherche:
        //une recherche sur la cle fonctionnelle issueraccount/receiveraccount --> il faut récuperer id à creuser pour connexion à base de données
        Holder issuerHolder = holderRepository.findById(transferSlip.getIssuerAccount());
        Holder receiverHolder = holderRepository.findById(transferSlip.getReceiverAccount());
        Balance issuerBalance = balanceRepository.findById(transferSlip.getIssuerAccount());
        Balance receiverBalance = balanceRepository.findById(transferSlip.getReceiverAccount());
        AccountingMovement issuerAccountingMovement = new AccountingMovement();
        AccountingMovement receiverAccountingMovement = new AccountingMovement();

        issuerAccountingMovement.setReference("reference mvt debit a définir");
        issuerAccountingMovement.setBalance((double)transferSlip.getBalance()* -1);
        issuerAccountingMovement.setOperationDate(transferSlip.getExecutionDate());
        issuerAccountingMovement.setValueDate(transferSlip.getExecutionDate().minusDays(1));
        issuerAccountingMovement.setLabel(transferSlip.getLabel()+ " à destination de " + receiverHolder.getName());
        accountingMovementRepository.save(issuerAccountingMovement);

        receiverAccountingMovement.setReference("reference mvt debit a définir");
        receiverAccountingMovement.setBalance(transferSlip.getBalance());
        receiverAccountingMovement.setOperationDate(transferSlip.getExecutionDate());
        receiverAccountingMovement.setValueDate(transferSlip.getExecutionDate().plusDays(1));
        receiverAccountingMovement.setLabel(transferSlip.getLabel()+ " de la part de " + issuerHolder.getName());
        accountingMovementRepository.save(receiverAccountingMovement);

        BigDecimal issuerBalanceBigDecimal = new BigDecimal(issuerBalance.getBalance()+issuerAccountingMovement.getBalance()).setScale(2, BigDecimal.ROUND_HALF_UP);
        issuerBalance.setBalance(issuerBalanceBigDecimal.doubleValue());
        balanceRepository.update(issuerBalance);

        BigDecimal receiverBalanceBigDecimal = new BigDecimal(receiverBalance.getBalance()+receiverAccountingMovement.getBalance()).setScale(2, BigDecimal.ROUND_HALF_UP);
        receiverBalance.setBalance(receiverBalanceBigDecimal.doubleValue());
        balanceRepository.update(receiverBalance);



        return issuerBalance.getAccount()+issuerBalance.getBalance()+receiverBalance.getAccount()+receiverBalance.getBalance();
    }
}
