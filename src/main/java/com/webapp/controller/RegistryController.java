package com.webapp.controller;


import com.webapp.model.CustomerAddressDTO;
import com.webapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistryController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/registry")
    public String getRegistryPage(){
        return "registry/registry";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public @ResponseBody CustomerAddressDTO
    addNewCustomer(@RequestBody CustomerAddressDTO newCustomer, HttpServletResponse response){
        CustomerAddressDTO customerAddressDTO = customerService.addNewCustomer(newCustomer);
        if(customerAddressDTO==null)
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        return customerAddressDTO;

    }
}
