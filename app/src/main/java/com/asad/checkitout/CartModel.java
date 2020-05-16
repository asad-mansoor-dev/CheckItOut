package com.asad.checkitout;

public class CartModel {

    public static final int CART_ITEM = 0;
    public static final int TOTAL_AMOUNT = 1;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    //// Cart Items

    private int productImage;
    private String productName;
    private String productPrice;
    private String productSize;
    private String productQuantity;

    public CartModel(int type, int productImage, String productName, String productPrice, String productSize, String productQuantity) {
        this.type = type;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSize = productSize;
        this.productQuantity = productQuantity;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    //// Cart Items


    //// Cart Items Total Amount

    private String totalItems;
    private String totalItemsPrice;
    private String deliveryCharges;
    private String totalPrice;

    public CartModel(int type, String totalItems, String totalItemsPrice, String deliveryCharges, String totalPrice) {
        this.type = type;
        this.totalItems = totalItems;
        this.totalItemsPrice = totalItemsPrice;
        this.deliveryCharges = deliveryCharges;
        this.totalPrice = totalPrice;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getTotalItemsPrice() {
        return totalItemsPrice;
    }

    public void setTotalItemsPrice(String totalItemsPrice) {
        this.totalItemsPrice = totalItemsPrice;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    //// Cart Items Total Amount
}
