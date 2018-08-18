package com.webapp.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderLineId;

    @Column(name="QUANTITY",nullable = false)
    private int quantity;

    @Column(name="NET_PRICE_PER_ITEM",nullable = false,precision = 6,scale=2)
    private double netPricePerItem;

    @Column(name="GROSS_PRICE_PER_ITEM",nullable = false,precision = 6,scale=2)
    private double grossPricePerItem;

    @Column(name="VAT", nullable = false,precision = 2,scale = 2)
    private double vat;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Cart cart;

    public long getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(long orderLineId) {
        this.orderLineId = orderLineId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getNetPricePerItem() {
        return netPricePerItem;
    }

    public void setNetPricePerItem(double netPricePerItem) {
        this.netPricePerItem = netPricePerItem;
    }

    public double getGrossPricePerItem() {
        return grossPricePerItem;
    }

    public void setGrossPricePerItem(double grossPricePerItem) {
        this.grossPricePerItem = grossPricePerItem;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
