package fr.training.samples.spring.shop.application.transferslip;

import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.transferslip.TransferSlip;

public interface TransferSlipService {

    /**
     * Create a new transferSlip
     *
     * @param transferSlip the TransferSlip to create
     * @return the created TransferSlip
     */
    public TransferSlip create(TransferSlip transferSlip);

    /**
     * Retrieve a transferSlip according to the given identifier.
     *
     * @param transferSlipId the transferSlip identifier
     * @return the retrieved TransferSlip
     */
    public TransferSlip findOne(String transferSlipId);

//    /**
//     * Run a transferSlip according to the given identifier.
//     *
//     * @param transferSlipId the transferSlip identifier
//     * @return the result of the run
//     */
//    public void runOne(String transferSlipId);

    /**
     * Run a transferSlip according to the given identifier.
     *
     * @param transferSlip the transferSlip identifier
     * @return the result of the run
     */
    public void runOne(TransferSlip transferSlip);

}
