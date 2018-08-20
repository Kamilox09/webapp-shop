package com.webapp.model.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="PRICE_DATE")
public class PriceDate {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long priceDateId;

    @Column(name = "FROM_DATE")
    private Timestamp fromDate;

    @Column(name="TO_DATE")
    private Timestamp toDate;

    @ManyToOne
    private Product product;

    public long getPriceDateId() {
        return priceDateId;
    }

    public void setPriceDateId(long priceDateId) {
        this.priceDateId = priceDateId;
    }

    public Timestamp getFromDate() {
        return fromDate;
    }

    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
