package com.demo.product.service.service;

import com.demo.product.service.dto.ProductRequest;
import com.demo.product.service.dto.ProductResponse;
import com.demo.product.service.mapper.ProductMapper;
import com.demo.product.service.model.Product;
import com.demo.product.service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = productMapper.mapProductRequestToProductEntity(productRequest);
        productRepository.save(product);
        //log.info("Product is created for id: {}", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return  productList.stream().map(product ->
            productMapper.mapProductEntityToProductResponse(product)).toList();
    }
}
