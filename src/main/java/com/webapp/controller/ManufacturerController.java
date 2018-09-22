package com.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ManufacturerController {

    @RequestMapping("/manufacturer")
    public String getManufacturerPage(){
        return "admin/manufacturer";
    }
}
