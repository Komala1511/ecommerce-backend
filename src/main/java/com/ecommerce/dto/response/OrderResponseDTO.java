package com.ecommerce.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderResponseDTO {
    private Long id;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private String status;
    private Long customerId;
    private String customerName;

    public OrderResponseDTO(){}

    //Getter


    public Long getId() {return id; }
    public BigDecimal getTotalAmount() {return totalAmount;}
    public LocalDateTime getOrderDate() { return orderDate;}
    public String getStatus() {return status;}
    public Long getCustomerId() {return customerId;}
    public String getCustomerName() {return customerName;}


    public void setId(Long id) { this.id = id;}
    public void setTotalAmount(BigDecimal totalAmount) {this.totalAmount = totalAmount;}
    public void setOrderDate(LocalDateTime orderDate) {this.orderDate = orderDate;}
    public void setStatus(String status) {this.status = status;}
    public void setCustomerId(Long customerId) {this.customerId = customerId;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
}
