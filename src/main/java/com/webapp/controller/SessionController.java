package com.webapp.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Properties;

@Controller
public class SessionController {

    @RequestMapping("/sessiondetails")
    public @ResponseBody Properties
            getSessionDetails(Principal principal){
        Properties properties = new Properties();
        String username = principal==null?"":principal.getName();
        properties.put("username",username);
        return properties;
    }
}
