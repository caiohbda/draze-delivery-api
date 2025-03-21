package draze.delivery.controller;

import draze.delivery.domain.model.Card;
import draze.delivery.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findById(@PathVariable Long id) {
        var card = cardService.findById(id);

        if (card == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(card);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Card cardToCreate) {
        try {
            var cardCreated = cardService.create(cardToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(cardCreated.getId())
                    .toUri();

            return ResponseEntity.created(location).body(cardCreated);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar cartão");
        }
    }
}
