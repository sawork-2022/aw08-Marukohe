package com.micropos.products.service;

import com.micropos.common.model.Product;
import com.micropos.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
        putAppleStore();
    }

    public void putAppleStore() {
        List<Product> list = Arrays.asList(
                new Product("0000001", "MacBook Pro", 14999.0, "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp-14-digitalmat-gallery-1-202111?wid=728&hei=666&fmt=png-alpha&.v=1635183223000"),
                new Product("0000002", "Mac Studio", 14999.0, "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mac-studio-digitalmat-gallery-1-202203?wid=728&hei=666&fmt=png-alpha&.v=1645207723410"),
                new Product("0000003", "iPhone 13 Pro", 8999.0,"https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone13pro-digitalmat-gallery-1-202203?wid=728&hei=666&fmt=png-alpha&.v=1645574660197"),
                new Product("0000004", "iPhone 13 mini", 5199.0, "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/iphone13mini-digitalmat-gallery-1-202203?wid=728&hei=666&fmt=png-alpha&.v=1645574660195"),
                new Product("0000005", "iPad mini", 3799.0, "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/ipad-mini-digitalmat-gallery-1-202111?wid=730&hei=666&fmt=png-alpha&.v=1635183174000")
        );
        productRepository.saveAll(list);
    }

    @Override
    public List<Product> products() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(
                product -> {
                    if (product.getPrice() > 0) {
                        products.add(product);
                    }
                }
        );
        return products;
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product randomProduct() {
        return null;
    }
}
