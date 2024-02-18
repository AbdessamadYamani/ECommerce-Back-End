package org.sid.inventoryservice.repository;

import jdk.jfr.Registered;
import org.sid.inventoryservice.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
