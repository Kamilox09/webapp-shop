package com.webapp.model.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long manufacturerId;

    @Column(name = "NAME",nullable = false)
    @Size(min=1)
    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> productList;

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
