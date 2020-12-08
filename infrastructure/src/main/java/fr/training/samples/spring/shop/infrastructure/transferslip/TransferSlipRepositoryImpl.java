package fr.training.samples.spring.shop.infrastructure.transferslip;

import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlipRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TransferSlipRepositoryImpl implements TransferSlipRepository {

    private final TransferSlipJpaRepository transferSlipJpaRepository;

    public TransferSlipRepositoryImpl(TransferSlipJpaRepository transferSlipJpaRepository) {
        this.transferSlipJpaRepository = transferSlipJpaRepository;
    }

    @Override
    public TransferSlip findById(String id) {
        return null;
    }

    @Override
    public void save(TransferSlip transferSlip) {

    }
}
