package fr.training.samples.spring.shop.domain.transferslip;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;

public interface TransferSlipRepository {

    public TransferSlip findById(String id);

    public void save(TransferSlip transferSlip);
}
