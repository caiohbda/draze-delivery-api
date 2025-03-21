package draze.delivery.service.impl;

import draze.delivery.domain.model.Card;
import draze.delivery.domain.repository.CardRepository;
import draze.delivery.service.CardService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Card create(Card cardToCreate) {
        return cardRepository.save(cardToCreate);
    }
}
