package fr.training.samples.spring.shop.domain.holder;

import fr.training.samples.spring.shop.domain.customer.Customer;

public interface HolderRepository {
    public Holder findById(String id);

}