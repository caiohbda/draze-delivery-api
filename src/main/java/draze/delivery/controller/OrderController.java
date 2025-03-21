package draze.delivery.controller;

import draze.delivery.domain.model.Order;
import draze.delivery.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        var order = orderService.findById(id);

        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Order orderToCreate) {
        try {
            var orderCreated = orderService.create(orderToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(orderCreated.getId())
                    .toUri();

            return ResponseEntity.created(location).body(orderCreated);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar pedido");
        }
    }
}
