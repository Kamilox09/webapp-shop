package com.webapp.model.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="PRICE_DATE")
public class PriceDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long priceDateId;

    @Column(name = "FROM")
    private Timestamp from;

    @Column(name="TO")
    private Timestamp to;

    @ManyToOne
    private Product product;

    public long getPriceDateId() {
        return priceDateId;
    }

    public void setPriceDateId(long priceDateId) {
        this.priceDateId = priceDateId;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
