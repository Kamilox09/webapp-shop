package com.webapp.controller;


import com.webapp.model.entity.Product;
import com.webapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping("/admin/product/add")
    public String getProductAddPage(){
        return "/admin/product/addProduct";
    }

    @RequestMapping(value = "/admin/product", method= RequestMethod.POST)
    public @ResponseBody
    Product addNewProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @RequestMapping("/admin/product/edit/{id}")
    public String getEditPage(@PathVariable long id){
        return "/admin/product/edit";
    }

    @RequestMapping(value = "/admin/product", method = RequestMethod.PUT)
    public @ResponseBody
    Product editProduct(@RequestBody Product product){
        return productService.editProduct(product);
    }


    @RequestMapping("/productcount")
    public @ResponseBody
    long getCountOfAllProducts(){
        return productService.getCountOfActiveProducts();
    }

    @RequestMapping("/productcount/{category}")
    public @ResponseBody
    long getCountOffProductsByCategory(@PathVariable("category") String categoryName){
        return productService.getCountOfActiveProductsByCategory(categoryName);
    }

    @RequestMapping(value = "/products/get",params = {"page"})
    public @ResponseBody
    List<Product> getProductsForPage(@RequestParam(value = "page") long page,
                                      @RequestParam(required = false,value = "category") String categoryName){
        return productService.getProductsForPage(page,categoryName);
    }

    @RequestMapping("/products")
    public String getProductsView(){
        return "/product/products";
    }

    @RequestMapping("/product/{id}")
    public String getProductDetailsView(@PathVariable("id") long id){
        return "/product/productdetail";
    }

    @RequestMapping("/product/get/{id}")
    public @ResponseBody
    Product getProductDetailById(@PathVariable("id") long id){
        return productService.getById(id);
    }


}
