package com.webapp.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long productId;

    @Column(name = "NAME",nullable=false)
    @Size(min=1,max=64)
    private String name;

    @Column(name="DESCRIPTION",nullable = false, length = 10000)
    @Size(min=1,max=10000)
    private String description;

    @Column(name = "NET_PRICE",nullable = false,precision = 6,scale=2)
    private double netPrice;

    @Column(name="GROSS_PRICE",nullable = false,precision = 6,scale=2)
    private double grossPrice;

    @Column(name="VAT", nullable = false,precision = 2,scale = 2)
    private double vat;

    @Column(name="QUANTITY",nullable = false)
    private int quantity;

    @Column(name="ACTIVE", nullable = false)
    private boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Photo> photoList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<PriceDate> priceDateList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderLine> orderLineList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    public List<PriceDate> getPriceDateList() {
        return priceDateList;
    }

    public void setPriceDateList(List<PriceDate> priceDateList) {
        this.priceDateList = priceDateList;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
