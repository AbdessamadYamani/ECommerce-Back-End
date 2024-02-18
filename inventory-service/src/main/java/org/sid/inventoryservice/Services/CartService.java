package org.sid.inventoryservice.Services;

import org.sid.inventoryservice.entites.Cart;
import org.sid.inventoryservice.entites.Product;
import org.sid.inventoryservice.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepository;

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public List<Product> getProductsInCart(Long cartId) {
        return cartRepository.findProductsByCartId(cartId);
    }

    public ResponseEntity<Product> getProductInCart(Long cartId) {
        List<Product> products = getProductsInCart(cartId);

        // Assuming you want to return a single product. If it's a list, adjust accordingly.
        if (!products.isEmpty()) {
            Product product = products.get(0);
            return ResponseEntity.ok(product);
        } else {
            // Handle the case when no product is found in the cart
            return ResponseEntity.notFound().build();
        }
    }

    public Double calculateCartSum(Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            List<Product> productsInCart = cart.getProductList();
            return calculateSum(productsInCart);
        } else {
            throw new NoSuchElementException("Cart not found with ID: " + cartId);
        }
    }

    private Double calculateSum(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.getById(cartId);
    }

    public Cart createCart(Cart cart) {
        // Implement validation or additional logic if needed
        return cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
