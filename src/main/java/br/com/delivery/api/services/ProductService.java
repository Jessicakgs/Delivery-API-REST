package br.com.delivery.api.services;

import br.com.delivery.api.dto.request.AssocProductOrderRequest;
import br.com.delivery.api.dto.request.ProductRequest;
import br.com.delivery.api.models.AssocProductOrder;
import br.com.delivery.api.models.Order;
import br.com.delivery.api.models.Product;
import br.com.delivery.api.repositories.AssocOrderProductRepository;
import br.com.delivery.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final AssocOrderProductRepository assocOrderProductRepository;

    public ProductService(ProductRepository productRepository, AssocOrderProductRepository assocOrderProductRepository, AssocOrderProductRepository assocOrderProductRepository1) {
        this.productRepository = productRepository;
        this.assocOrderProductRepository = assocOrderProductRepository1;
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



    public AssocProductOrder parseToAssocOrderProduct(AssocProductOrderRequest dto) {
        var assoc = new AssocProductOrder();
        Product product = productRepository.findById(dto.productId()).orElseThrow(RuntimeException::new);
        assoc.setProduct(product);
        assoc.setQuantity(dto.quantity());
        return assoc;
    }

    public void saveAssocOrderProduct(List<AssocProductOrder> products, Order order) {
        products.forEach(assoc -> assoc.setOrder(order));
        assocOrderProductRepository.saveAll(products);
    }
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    }

