package com.ecommerce.entity;

import jakarta.persistence.*;



import java.util.List;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;

    private String address;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Customer() {
    }

    //Getters
    public Long getId() { return id;}
    public String getName() {return name;}
    public String getEmail() { return email;}
    public String getPhone() {return phone;}
    public String getAddress() {return address;}


    public List<Order> getOrders() {return orders;}


    //Setters
    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setAddress(String address) {this.address = address;}
    public void setOrders(List<Order> orders) {this.orders = orders;}
}



