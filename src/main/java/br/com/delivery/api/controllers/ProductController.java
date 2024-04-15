package br.com.delivery.api.controllers;

import br.com.delivery.api.dto.request.ProductRequest;
import br.com.delivery.api.models.Product;
import br.com.delivery.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest product) {
        productService.createProduct(product);
        return ResponseEntity.ok("Produto criado com sucesso!");
    }


}
