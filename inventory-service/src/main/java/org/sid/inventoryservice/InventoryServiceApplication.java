package org.sid.inventoryservice;

import org.sid.inventoryservice.entites.Cart;
import org.sid.inventoryservice.entites.Customer_Order;
import org.sid.inventoryservice.entites.Product;
import org.sid.inventoryservice.repository.CartRepo;
import org.sid.inventoryservice.repository.OrderRepo;
import org.sid.inventoryservice.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.awt.*;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CartRepo CR, ProductRepo PR, OrderRepo CO){
		return args -> {
			PR.save(new Product(18L,"SSSS","SSS",154,""));
			PR.save(new Product(17L,"LLLLL","PPPPPP",189,""));
			PR.save(new Product(16L,"AAAAAAA","DDDDD",19,""));
			PR.save(new Product(15L,"MMMMM","IIIIIIII",18,""));
			PR.save(new Product(14L,"WWWWW","QQQQQQQ",1890,""));


			List<Product> products1 = PR.findAll().subList(0, 3);
			List<Product> products2 = PR.findAll().subList(3,5);
			Cart cart1 = new Cart(1L,products1, new Date(System.currentTimeMillis()));
			CR.save(cart1);
			Cart cart2 = new Cart(2L,products2, new Date(System.currentTimeMillis()));

			CR.save(cart2);

			Customer_Order order1 = new Customer_Order(1L,1L, cart1,  new Date(System.currentTimeMillis()));
			CO.save(order1);
			Customer_Order order2 = new Customer_Order(2L,2L, cart2,  new Date(System.currentTimeMillis()));
			CO.save(order2);
		};
	}

}
