package com.ecommerce.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    public Product(){}
    public Product(String name,String description, BigDecimal price,Integer quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public BigDecimal getPrice() {return price;}
    public Integer getQuantity() {return quantity;}


    public void setId(long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
}



