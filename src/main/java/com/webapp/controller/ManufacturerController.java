package com.webapp.controller;


import com.webapp.model.entity.Manufacturer;
import com.webapp.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ManufacturerController {


    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService){
        this.manufacturerService=manufacturerService;
    }

    @RequestMapping("/manufacturer")
    public String getManufacturerPage(){
        return "admin/manufacturer/manufacturer";
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

    @RequestMapping(value = "/manufacturer/edit/{id}", method = RequestMethod.GET)
    public String getEditPage(@PathVariable("id") Long manufacturerId){
                return "admin/manufacturer/edit";
    }

    @RequestMapping(value = "/manufacturer/get/{id}",method = RequestMethod.GET)
    public @ResponseBody Manufacturer
        getManufacturerById(@PathVariable("id") Long manufacturerId){
            return manufacturerService.getManufacturerById(manufacturerId);
    }

    @RequestMapping(value="/manufacturer",method = RequestMethod.PUT)
    public @ResponseBody Manufacturer
        updateManufacturer(@RequestBody Manufacturer manufacturer, HttpServletResponse response){
            Manufacturer returned = manufacturerService.updateManufacturer(manufacturer);
            if(returned==null)
                response.setStatus(HttpServletResponse.SC_CONFLICT);
            return returned;
    }

    @RequestMapping(value = "/manufacturer", method = RequestMethod.DELETE)
    public ResponseEntity deleteManufacturer(@RequestParam("id") long id){
        manufacturerService.deleteManufacturerById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
