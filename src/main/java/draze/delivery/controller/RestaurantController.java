package draze.delivery.controller;

import draze.delivery.domain.model.Restaurant;
import draze.delivery.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id) {
        var restaurant = restaurantService.findById(id);

        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurant);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Restaurant restaurantToCreate) {
        try {
            var restaurantCreated = restaurantService.create(restaurantToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(restaurantCreated.getId())
                    .toUri();

            return ResponseEntity.created(location).body(restaurantCreated);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar restaurante");
        }
    }
}
