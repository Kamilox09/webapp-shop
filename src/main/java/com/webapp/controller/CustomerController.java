package com.webapp.controller;

import com.webapp.model.entity.Customer;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
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
}
