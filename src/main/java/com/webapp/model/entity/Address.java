package com.webapp.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long addressId;

    @Column(name="CITY")
    private String city;

    @Column(name="STREET")
    private String street;

    @Column(name="ZIP_CODE")
    private String zipCode;

    @Column(name="HOUSE_NUMBER")
    private String houseNumber;

    @Column(name="LOCAL_NUMBER")
    private String localNumber;

    @Column(name="FROM_DATE")
    private Timestamp fromDate;

    @Column(name="TO_DATE")
    private Timestamp toDate;

    @ManyToOne
    private Customer customer;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
