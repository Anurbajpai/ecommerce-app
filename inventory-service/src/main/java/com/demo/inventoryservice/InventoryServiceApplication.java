package com.demo.inventoryservice;

import com.demo.inventoryservice.model.Inventory;
import com.demo.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadInventory(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory1 = Inventory.builder().
					skuCode("121574TH").quantity(100).build();

			Inventory inventory2 = Inventory.builder().
					skuCode("121575TH").quantity(0).build();

			Inventory inventory3 = Inventory.builder().
					skuCode("121576TH").quantity(50).build();
			inventoryRepository.saveAll(Arrays.asList(inventory1, inventory2, inventory3));
		};

	}

}
