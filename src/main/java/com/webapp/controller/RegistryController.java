package com.webapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistryController {

    @RequestMapping("/registry")
    public String getRegistryPage(){
        return "registry/registry";
    }
}
