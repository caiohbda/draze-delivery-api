package draze.delivery.service.impl;

import draze.delivery.domain.model.Order;
import draze.delivery.domain.repository.OrderRepository;
import draze.delivery.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Order create(Order orderToCreate) {
        return orderRepository.save(orderToCreate);
    }
}
