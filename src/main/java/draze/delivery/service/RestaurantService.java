package draze.delivery.service;

import draze.delivery.domain.model.Restaurant;

public interface RestaurantService {

    Restaurant findById(Long id);

    Restaurant create(Restaurant restaurantToCreate);
}
