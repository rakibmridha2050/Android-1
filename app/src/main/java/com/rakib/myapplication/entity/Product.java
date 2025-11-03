package com.rakib.myapplication.entity;

public class Product {

    private int id;
    private String name;
    private String email;
    private Double price;
    private Integer quantity;


    //CONSTRUCTOR
    public Product() {
    }

    public Product(Integer quantity, Double price, String email, String name) {
        this.quantity = quantity;
        this.price = price;
        this.email = email;
        this.name = name;
    }

    public Product(int id, Integer quantity, Double price, String email, String name) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.email = email;
        this.name = name;
    }


    //GETTER AND SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
