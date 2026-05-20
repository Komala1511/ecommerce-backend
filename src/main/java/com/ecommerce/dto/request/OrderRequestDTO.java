package com.ecommerce.dto.request;

import java.math.BigDecimal;

public class OrderRequestDTO {
    private Long customerId;
    private BigDecimal totalAmount;

    public OrderRequestDTO(){}

    //GETTER

    public Long getCustomerId() {return customerId;}
    public BigDecimal getTotalAmount() {return totalAmount;}
//SETTER
    public void setCustomerId(Long customerId) {this.customerId = customerId;}
    public void setTotalAmount(BigDecimal totalAmount) {this.totalAmount = totalAmount;}
}
