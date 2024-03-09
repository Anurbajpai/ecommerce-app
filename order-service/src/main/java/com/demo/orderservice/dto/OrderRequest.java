package com.demo.orderservice.dto;

import java.util.List;

public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsList;

    public List<OrderLineItemsDto> getOrderLineItemsList() {
        return orderLineItemsList;
    }

    public void setOrderLineItemsList(List<OrderLineItemsDto> orderLineItemsList) {
        this.orderLineItemsList = orderLineItemsList;
    }
}
