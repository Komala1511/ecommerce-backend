package com.ecommerce.dto.response;

import java.math.BigDecimal;

    public class ProductResponseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public ProductResponseDTO(){}

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public BigDecimal getPrice() {return price;}
    public Integer getQuantity() {return quantity;}

    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
}
