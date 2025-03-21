package draze.delivery.service;

import draze.delivery.domain.model.Order;

public interface OrderService {

    Order findById(Long id);

    Order create(Order orderToCreate);
}
