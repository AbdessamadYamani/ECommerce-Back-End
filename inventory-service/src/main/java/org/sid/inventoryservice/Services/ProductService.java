package org.sid.inventoryservice.Services;

import org.sid.inventoryservice.entites.Cart;
import org.sid.inventoryservice.entites.Product;
import org.sid.inventoryservice.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private  ProductRepo productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    public Product createProduct(Product product) {
        // Implement validation or additional logic if needed
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product product) {
        // Implement validation or additional logic if needed
        Optional<Product> optionalExistingProduct = productRepository.findById(productId);
        if (optionalExistingProduct.isPresent()) {
            Product existingProduct = optionalExistingProduct.get();
            // Update fields based on your requirements
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            // ... other fields

            return productRepository.save(existingProduct);
        }
        return null; // Handle not found scenario
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
