package com.example.addfoods;

public class User {
    private String title;
    private String author;
    private Double price;
    private Integer servings;
    private Double preparation;
    private Double cook;
    private Double total;

    public User() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public Double getPreparation() {
        return preparation;
    }

    public void setPreparation(Double preparation) {
        this.preparation = preparation;
    }

    public Double getCook() {
        return cook;
    }

    public void setCook(Double cook) {
        this.cook = cook;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}