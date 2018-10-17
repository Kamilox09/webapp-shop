package com.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @RequestMapping("/account/{username}")
    public String getAccountInfoPage(@PathVariable("username") String username){
        return "/account/account";
    }
}
