package com.ecommerce.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal totalAmount;
    @Column(nullable = false)
    private LocalDateTime orderDate;
    @Column( nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name ="customer_id", nullable = false)
    private Customer customer;

    public Order(){}

    public Long getId() {return id;}

    public BigDecimal getTotalAmount() {return totalAmount;}
    public LocalDateTime getOrderDate() {return orderDate;}
    public String getStatus() {return status;}
    public Customer getCustomer() {return customer;}

    public void setId(Long id) {this.id = id;}

    public void setTotalAmount(BigDecimal totalAmount) {this.totalAmount = totalAmount;}
    public void setOrderDate(LocalDateTime orderDate) {this.orderDate = orderDate;}
    public void setStatus(String status) {this.status = status;}
    public void setCustomer(Customer customer) {this.customer = customer;}
}
