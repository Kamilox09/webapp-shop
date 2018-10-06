package com.webapp.controller;


import com.webapp.model.entity.Product;
import com.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }


    @RequestMapping("/admin/product")
    public String getListProductPage(){
        return "admin/product/product";
    }

    @RequestMapping("/admin/product/get/{id}")
    public @ResponseBody
    Product getProductById(@PathVariable("id") long id){
        return productService.getById(id);
    }

    @RequestMapping("/admin/product/all")
    public @ResponseBody
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
