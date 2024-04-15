package br.com.delivery.api.services;

import br.com.delivery.api.dto.request.ProductRequest;
import br.com.delivery.api.models.Product;
import br.com.delivery.api.repositories.ProductRepository;
import ch.qos.logback.classic.LoggerContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }

    public void updatedProduct(Integer id, ProductRequest updatedProduct) {

        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
            product.setName(updatedProduct.getName());
            product.setPrice(updatedProduct.getPrice());
            productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
