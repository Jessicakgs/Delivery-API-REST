package br.com.delivery.api.services;

import br.com.delivery.api.repositories.CustomerRepository;
import br.com.delivery.api.dto.request.OrderRequest;
import br.com.delivery.api.models.AssocProductOrder;
import br.com.delivery.api.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }


    public void createOrder(OrderRequest orderRequest) {
        var custoomer = customerRepository.findById(orderRequest.customerId()).orElseThrow(RuntimeException::new);
        orderRequest.products().stream().map( assocProductOrderRequest -> new AssocProductOrder())

    }


}
