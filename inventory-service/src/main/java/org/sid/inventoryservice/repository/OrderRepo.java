package org.sid.inventoryservice.repository;

import java.util.List;

import org.sid.inventoryservice.entites.Customer_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Customer_Order, Long> {

}
