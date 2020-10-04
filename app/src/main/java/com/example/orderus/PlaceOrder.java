package com.example.orderus;

public class PlaceOrder {

    private String name;
    private String id;
    private String address;
    private Integer quantity;
    private String size;
    private Integer notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getNotes() {
        return notes;
    }

    public void setNotes(Integer notes) {
        this.notes = notes;
    }

    public PlaceOrder() {
    }
}
