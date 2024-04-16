package br.com.delivery.api.models;

import br.com.delivery.api.enums.OrderStatusEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "id_customer", nullable = false)
    private Customer customer;

    @OneToMany
    private Set<AssocProductOrder> products;

    private String address;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status = OrderStatusEnum.RECEIVED;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AssocProductOrder> getProducts() {
        return products;
    }

    public void setProducts(Set<AssocProductOrder> products) {
        this.products = products;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
