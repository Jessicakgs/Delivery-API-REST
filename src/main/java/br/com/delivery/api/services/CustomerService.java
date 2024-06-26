package br.com.delivery.api.services;

import br.com.delivery.api.dto.request.CustomerRequest;
import br.com.delivery.api.models.Customer;
import br.com.delivery.api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();

        customer.setName(customerRequest.getName());
        customer.setNumberPhone(customerRequest.getNumberPhone());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {customerRepository.deleteById(id);}

    public void updateCustomer(Integer id, CustomerRequest updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        customer.setName(updatedCustomer.getName());
        customer.setNumberPhone(updatedCustomer.getNumberPhone());
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
