package com.webapp.controller;

import com.webapp.model.entity.Address;
import com.webapp.model.entity.Customer;
import com.webapp.service.AddressService;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@Controller
public class AccountController {

    private final CustomerService customerService;
    private final AddressService addressService;

    @Autowired
    public AccountController(CustomerService customerService, AddressService addressService){
        this.customerService=customerService;
        this.addressService=addressService;
    }

    @RequestMapping("/account/{username}")
    public String getAccountInfoPage(@PathVariable("username") String username){
        return "/account/account";
    }

    @RequestMapping("/customer/get/{username}")
    public @ResponseBody
    Customer getCustomerByUsername(@PathVariable("username") String username){
        return customerService.getCustomerByUsername(username);
    }

    @RequestMapping("/editaccount/{username}")
    public String getEditAccountView(@PathVariable("username") String username){
        return "/account/editaccount";
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public @ResponseBody
    Customer editAccount(@RequestBody Customer customer){
        return customerService.editCustomer(customer);
    }

    @RequestMapping("/editaddress/{username}")
    public String getEditAddressView(@PathVariable("username") String username){
        return "/account/editaddress";
    }

    @RequestMapping("/address/get/{username}")
    public @ResponseBody
    Address getAddressByUsername(@PathVariable("username") String username){
        return addressService.getCurrentAddressByCustomer(customerService.getCustomerByUsername(username));
    }

    @RequestMapping(value = "/address",method = RequestMethod.PUT)
    public @ResponseBody
    Address editAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @RequestMapping("/changepassword/{username}")
    public String getChangePasswordPage(@PathVariable("username") String username){
        return "/account/changepassword";
    }

    @RequestMapping(value = "/changepassword/{username}", method = RequestMethod.PUT)
    public @ResponseBody
    Customer changePassword(@PathVariable("username") String username, @RequestBody Properties properties, HttpServletResponse response){
        Customer customer = customerService.changePassword(username,properties.getProperty("old"),properties.getProperty("new"));
        if(customer==null)
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return customer;
    }
}
