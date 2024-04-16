package br.com.delivery.api.controllers;

import br.com.delivery.api.dto.request.ProductRequest;
import br.com.delivery.api.models.Product;
import br.com.delivery.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest updatedProduct) {
        productService.updatedProduct(id, updatedProduct);
        return ResponseEntity.ok("Produto atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Produto excluído com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }



}
