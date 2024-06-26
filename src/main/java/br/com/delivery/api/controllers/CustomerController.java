package br.com.delivery.api.controllers;


import br.com.delivery.api.dto.request.CustomerRequest;
import br.com.delivery.api.models.Customer;
import br.com.delivery.api.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        customerService.createCustomer(customerRequest); // assumindo que você tem um método createCustomer em CustomerService
        return ResponseEntity.ok("Cliente criado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Cliente excluído com sucesso!");

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody @Valid CustomerRequest updatedCustomer) {
        customerService.updateCustomer(id, updatedCustomer);
        return ResponseEntity.ok("Cliente atualizado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    }

