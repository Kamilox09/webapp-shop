package com.webapp.model;


import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAddressDTO {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String company;
    private String nip;
    private String regon;
    private String email;
    private String city;
    private String zipCode;
    private String street;
    private String localNumber;

    public Customer getCustomerWithAddress(){
        Customer customer = new Customer();
        customer.setLogin(login);
        customer.setPassword(password);
        customer.setName(name);
        customer.setSurname(surname);
        customer.setCompany(company);
        customer.setNip(nip);
        customer.setRegon(regon);
        customer.setEmail(email);
        Address address = new Address();
        address.setCity(city);
        address.setZipCode(zipCode);
        address.setStreet(street);
        address.setLocalNumber(localNumber);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        customer.setAddressList(addressList);
        return customer;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }
}
