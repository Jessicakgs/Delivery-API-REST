package br.com.delivery.api.controllers;

import br.com.delivery.api.dto.request.OrderRequest;
import br.com.delivery.api.dto.request.ProductRequest;
import br.com.delivery.api.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
    }

    @GetMapping("/{orderId}/status")
    public ResponseEntity<Integer> getOrderStatus(@PathVariable("orderId") Integer orderId) {
        return ResponseEntity.ok(orderId);
    }

    @PutMapping("/{orderId}/")
    public ResponseEntity<?> updateOrder(@PathVariable Integer id, @RequestBody OrderRequest updatedOrder) {
        orderService.updatedOrder(id, updatedOrder);
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }
}
