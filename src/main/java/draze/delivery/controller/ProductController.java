package draze.delivery.controller;

import draze.delivery.domain.model.Product;
import draze.delivery.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        var product = productService.findById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Product productToCreate) {
        try {
            var productCreated = productService.create(productToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(productCreated.getId())
                    .toUri();

            return ResponseEntity.created(location).body(productCreated);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar produto");
        }
    }
}
