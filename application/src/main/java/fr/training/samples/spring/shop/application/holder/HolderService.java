package fr.training.samples.spring.shop.application.holder;

import fr.training.samples.spring.shop.domain.accountingmovement.AccountingMovement;
import fr.training.samples.spring.shop.domain.balance.Balance;
import fr.training.samples.spring.shop.domain.holder.Holder;

public interface HolderService {

    /**
     * Retrieve a holder according to the given identifier.
     *
     * @param holderId the holder identifier
     * @return the retrieved holder
     */
    public Holder findOneById(String holderId);

    /**
     * Retrieve a holder according to be save.
     *
     * @param holder the holder to be save
     * @return the holder
     */
    public Holder addHolder(Holder holder);
}
