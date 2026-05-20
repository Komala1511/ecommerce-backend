package com.ecommerce.dto.request;

import java.math.BigDecimal;

public class ProductRequestDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;


    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name, String description, BigDecimal price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public BigDecimal getPrice() {return price;}
    public Integer getQuantity() {return quantity;}

    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}


}


