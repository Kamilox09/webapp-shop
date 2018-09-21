package com.webapp.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long customerId;

    @Column(name="LOGIN",unique = true,nullable = false)
    @Size(min=4,max=20)
    private String login;

    @Column(name="PASSWORD",nullable = false)
    @Size(min=5,max=20)
    private String password;

    @Column(name="NAME",nullable = false)
    @Size(min=1)
    private String name;

    @Column(name="SURNAME",nullable = false)
    @Size(min=1)
    private String surname;

    @Column(name="COMPANY")
    private String company;

    @Column(name="NIP")
    private String nip;

    @Column(name="REGON")
    private String regon;

    @Column(name="EMAIL",nullable = false,unique = true)
    private String email;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @Column(name="ROLE", nullable = false)
    private String role;

    @OneToMany(mappedBy = "customer")
    private List<Cart> cartList;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Address> addressList;

    public void addAddress(Address address){
        if(addressList==null)
            addressList=new ArrayList<Address>();
        addressList.add(address);
        address.setCustomer(this);

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String type) {
        this.role = type;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
