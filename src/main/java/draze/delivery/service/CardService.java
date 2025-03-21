package draze.delivery.service;

import draze.delivery.domain.model.Card;

public interface CardService {

    Card findById(Long id);

    Card create(Card cardToCreate);
}
