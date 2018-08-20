package com.webapp.model.entity;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long cartId;

    @Column(name="TOTAL_PRICE")
    private double totalPrice;

    @Column(name="IS_PAID")
    private boolean isPaid;

    @Column(name="DISPATCH_DATE")
    private Timestamp dispatchDate;

    @Column(name="PURCHASE_DATE")
    private Timestamp purchaseDate;

    @OneToMany(mappedBy = "cart")
    private List<OrderLine> orderLineList;

    @ManyToOne
    private Customer customer;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Timestamp getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Timestamp dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
