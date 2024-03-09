package com.demo.orderservice.service;

import com.demo.orderservice.dto.InventoryResponse;
import com.demo.orderservice.dto.OrderLineItemsDto;
import com.demo.orderservice.dto.OrderRequest;
import com.demo.orderservice.mapper.OrderMapper;
import com.demo.orderservice.model.Order;
import com.demo.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){

        List<String> skuCodes = orderRequest.getOrderLineItemsList().stream().map(OrderLineItemsDto::getSku).toList();
        List<InventoryResponse> inventoryResponse = inventoryClient.get().uri(uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve().bodyToMono(new ParameterizedTypeReference<List<InventoryResponse>>() {}).block();

        if(!CollectionUtils.isEmpty(inventoryResponse)) {
            boolean allItemsInStock = inventoryResponse.stream().allMatch(inventoryResponse1 -> inventoryResponse1.isInStock());
            if(allItemsInStock){
                Order orderEntity = orderMapper.mapOrderRequestToOrderEntity(orderRequest);
                orderRepository.save(orderEntity);
                return;
            }
        }
        throw new IllegalArgumentException("Products not in stock");
    }
}
