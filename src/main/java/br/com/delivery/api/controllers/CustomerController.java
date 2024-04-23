package br.com.delivery.api.controllers;


import br.com.delivery.api.dto.request.CustomerRequest;
import br.com.delivery.api.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}