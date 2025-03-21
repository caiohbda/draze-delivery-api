package draze.delivery.controller;

import draze.delivery.domain.model.Address;
import draze.delivery.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> findById(@PathVariable Long id) {
        var address = addressService.findById(id);

        if (address == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(address);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Address addressToCreate) {
        try {
            var addressCreated = addressService.create(addressToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(addressCreated.getId())
                    .toUri();

            return ResponseEntity.created(location).body(addressCreated);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar endereço");
        }
    }
}
