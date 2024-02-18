package org.sid.inventoryservice.Controllers;

import org.sid.inventoryservice.Services.OrderService;
import org.sid.inventoryservice.entites.CustomerDTO;
import org.sid.inventoryservice.entites.Customer_Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/CustomerOrder")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private RestTemplate restTemplate;

    @Value("${customer.service.url}")
    private String customerServiceUrl;

    public void OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{orderId}/customerId")
    public Object getObjectWithCustomerDetails(Long orderId) {
        String customerUrl = customerServiceUrl ;

        ResponseEntity<Customer_Order> orderResponse = getOrderById(orderId);
        if (orderResponse.getBody() != null) {
            long customerIdd = orderResponse.getBody().getId();

            // Make a request to the Customer microservice to get the customer details
            ResponseEntity<CustomerDTO> customerResponse = restTemplate.getForEntity(customerUrl + "/user/{customerIdd}",CustomerDTO.class, 2);

            CustomerDTO result = new CustomerDTO();

            return result;
        } else {
            return null; // Handle the case where the order is not found
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer_Order>> getAllOrders() {
        List<Customer_Order> allOrders = orderService.getAllOrders();
        if (!allOrders.isEmpty()) {
            return ResponseEntity.ok(allOrders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Customer_Order> getOrderById(@PathVariable Long orderId) {
        Customer_Order customerOrder = orderService.getOrderById(orderId);
        if (customerOrder != null) {
            return ResponseEntity.ok(customerOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer_Order> createOrder(@RequestBody Customer_Order customerOrder) {
        Customer_Order createdCustomerOrder = orderService.createOrder(customerOrder);
        return ResponseEntity.ok(createdCustomerOrder);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
