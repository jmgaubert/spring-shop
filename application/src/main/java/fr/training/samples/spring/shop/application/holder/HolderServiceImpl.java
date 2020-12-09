package fr.training.samples.spring.shop.application.holder;

import fr.training.samples.spring.shop.domain.holder.Holder;
import fr.training.samples.spring.shop.domain.holder.HolderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HolderServiceImpl implements HolderService {

    private final HolderRepository holderRepository;

    public HolderServiceImpl(HolderRepository holderRepository) {
        this.holderRepository = holderRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Holder findOneById(final String holderId) {
        return holderRepository.findById(holderId);
    }

    @Transactional
    @Override
    public Holder addHolder(final Holder holder) {
        holderRepository.save(holder);
        return holder;
    }
}
