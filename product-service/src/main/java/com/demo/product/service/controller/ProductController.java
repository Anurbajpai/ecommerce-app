package com.demo.product.service.controller;

import com.demo.product.service.dto.ProductRequest;
import com.demo.product.service.dto.ProductResponse;
import com.demo.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
