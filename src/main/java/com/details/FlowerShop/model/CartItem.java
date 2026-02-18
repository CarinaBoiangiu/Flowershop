package com.details.FlowerShop.model;

public class CartItem {
    private Buchet buchet;
    private int quantity;

    public CartItem(Buchet buchet, int quantity) {
        this.buchet = buchet;
        this.quantity = quantity;
    }

    public Buchet getBuchet() { return buchet; }
    public void setBuchet(Buchet buchet) { this.buchet = buchet; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() { return buchet.getPret() * quantity; }
}