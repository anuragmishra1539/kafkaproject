package com.productsz.ProductsMicroservice.productcontroller;


import com.core.events.products.Product;
import com.productsz.ProductsMicroservice.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/newproduct")
    public String newProduct(Product product){
          return   productService.newProduct(product);
    }



}
