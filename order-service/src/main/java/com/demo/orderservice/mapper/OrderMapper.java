package com.demo.orderservice.mapper;

import com.demo.orderservice.dto.OrderRequest;
import com.demo.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order mapOrderRequestToOrderEntity(OrderRequest orderRequest);

    //Order mapOrderRequestToOrderEntity(OrderRequest orderRequest);
}
