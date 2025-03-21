package draze.delivery.service.impl;

import draze.delivery.domain.model.Restaurant;
import draze.delivery.domain.repository.RestaurantRepository;
import draze.delivery.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Restaurant create(Restaurant restaurantToCreate) {
        return restaurantRepository.save(restaurantToCreate);
    }
}
