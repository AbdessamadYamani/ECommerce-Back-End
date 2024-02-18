package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entites.Cart;
import org.sid.inventoryservice.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    @Query("SELECT c.productList FROM Cart c WHERE c.cartId = :cartId")
    List<Product> findProductsByCartId(@Param("cartId") Long cartId);


}
