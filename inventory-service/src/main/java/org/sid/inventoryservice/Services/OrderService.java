package org.sid.inventoryservice.Services;

import java.util.List;
import java.util.Optional;

import org.sid.inventoryservice.entites.Cart;
import org.sid.inventoryservice.entites.Customer_Order;
import org.sid.inventoryservice.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepository;



    public Customer_Order getOrderById(Long orderId) {
        Optional<Customer_Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }
    public List<Customer_Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Customer_Order createOrder(Customer_Order customerOrder) {
        // Implement validation or additional logic if needed
        return orderRepository.save(customerOrder);
    }



    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
