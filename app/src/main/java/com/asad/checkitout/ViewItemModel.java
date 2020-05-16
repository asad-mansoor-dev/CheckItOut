package com.asad.checkitout;

import android.graphics.Bitmap;

public class ViewItemModel {

    private String name;
    private Bitmap image;
    private String description;
    private String price;
    private String size;
    private String brand;
    private int quantity;

    public ViewItemModel(String name, Bitmap image, String description, String price, String size, String brand, int quantity) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.price = price;
        this.size = size;
        this.brand = brand;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Bitmap getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
