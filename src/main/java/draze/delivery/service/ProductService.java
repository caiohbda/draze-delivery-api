package draze.delivery.service;

import draze.delivery.domain.model.Product;

public interface ProductService {

    Product findById(Long id);

    Product create(Product productToCreate);
}
