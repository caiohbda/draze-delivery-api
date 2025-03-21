package draze.delivery.service.impl;

import draze.delivery.domain.model.Product;
import draze.delivery.domain.repository.ProductRepository;
import draze.delivery.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product create(Product productToCreate) {
        return productRepository.save(productToCreate);
    }
}
