package br.com.delivery.api.services;

import br.com.delivery.api.enums.OrderStatusEnum;
import br.com.delivery.api.models.Order;
import br.com.delivery.api.repositories.CustomerRepository;
import br.com.delivery.api.dto.request.OrderRequest;
import br.com.delivery.api.models.AssocProductOrder;
import br.com.delivery.api.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.net.Proxy;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productService = productService;
    }


    public void createOrder(OrderRequest orderRequest) {
        var customer = customerRepository.findById(orderRequest.customerId()).orElseThrow(RuntimeException::new);
        List<AssocProductOrder> products = orderRequest.products().stream().map(productService::parseToAssocOrderProduct).toList();
        var order = new Order();
        order.setCustomer(customer);
        order.setAddress(orderRequest.address());
        productService.saveAssocOrderProduct(products, orderRepository.save(order));
    }

    public OrderStatusEnum getOrderStatus(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        return order.getStatus();
    }

    public void updatedOrder(Integer id, OrderRequest updatedOrder) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        order.setCustomer(customerRepository.findById(updatedOrder.customerId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado")));
        order.setAddress(updatedOrder.address());
        List<AssocProductOrder> products = updatedOrder.products().stream().map(productService::parseToAssocOrderProduct).toList();
        productService.saveAssocOrderProduct(products, order);
    }



}
