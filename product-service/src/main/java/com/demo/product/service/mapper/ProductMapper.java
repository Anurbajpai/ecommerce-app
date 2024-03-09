package com.demo.product.service.mapper;


import com.demo.product.service.dto.ProductRequest;
import com.demo.product.service.dto.ProductResponse;
import com.demo.product.service.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapProductRequestToProductEntity(ProductRequest productRequest);
    ProductResponse mapProductEntityToProductResponse(Product product);
}
