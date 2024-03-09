package com.demo.inventoryservice.service;

import com.demo.inventoryservice.dto.InventoryResponse;
import com.demo.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    public List<InventoryResponse> isInStock(List<String> skuCodes) {

       return inventoryRepository.findBySkuCodeIn(skuCodes).stream().map(inventory ->
             InventoryResponse.builder()
                    .skuCode(inventory.getSkuCode())
                    .isInStock(inventory.getQuantity() > 0).build()).toList();
    }
}
