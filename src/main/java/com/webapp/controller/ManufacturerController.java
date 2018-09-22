package com.webapp.controller;


import com.webapp.model.entity.Manufacturer;
import com.webapp.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping("/manufacturer")
    public String getManufacturerPage(){
        return "admin/manufacturer";
    }

    @RequestMapping(value = "/manufacturer", method = RequestMethod.POST)
    public @ResponseBody Manufacturer
            addManufacturer(@RequestBody Manufacturer manufacturer, HttpServletResponse response){
            Manufacturer returned = manufacturerService.addManufacturer(manufacturer);
            if(returned==null)
                response.setStatus(HttpServletResponse.SC_CONFLICT);
            return returned;
    }

    @RequestMapping(value = "/manufacturer/all",method = RequestMethod.GET)
    public @ResponseBody List<Manufacturer>
            getAllManufacturers(){
                return manufacturerService.getAllManufacturers();
    }
}
