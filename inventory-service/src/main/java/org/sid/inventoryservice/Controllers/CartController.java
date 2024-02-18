package org.sid.inventoryservice.Controllers;

import org.sid.inventoryservice.Services.CartService;
import org.sid.inventoryservice.entites.Cart;
import org.sid.inventoryservice.entites.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        List<Cart> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }
    @GetMapping("/{cartId}/sum")
    public ResponseEntity<Double> calculateCartSum(@PathVariable Long cartId) {
        Double cartSum = cartService.calculateCartSum(cartId);
        return ResponseEntity.ok(cartSum);
    }
    @GetMapping("/{cartId}/product")
    public ResponseEntity<List<Product>> getProductsInCart(@PathVariable Long cartId) {
        List<Product> products = cartService.getProductsInCart(cartId);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart createdCart = cartService.createCart(cart);
        return ResponseEntity.ok(createdCart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }
}
