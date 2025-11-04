package com.rakib.myapplication.entity;

public class Product {

    private int id;
    private String name;
    private String email;
    private Double price;
    private Integer quantity;
    private String imageUri;

    public Product() {
    }

    public Product(String imageUri, Integer quantity, Double price, String email, String name) {
        this.imageUri = imageUri;
        this.quantity = quantity;
        this.price = price;
        this.email = email;
        this.name = name;
    }

    public Product(int id, String name, String email, Double price, Integer quantity, String imageUri) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.price = price;
        this.quantity = quantity;
        this.imageUri = imageUri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
