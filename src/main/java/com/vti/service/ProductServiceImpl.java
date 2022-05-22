package com.vti.service;

import com.vti.entity.Product;
import com.vti.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProduct() {
        List<Product> getListProduct = productRepository.findAll();
        return getListProduct;
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAllIdDesc() {
        return productRepository.findAllIdDesc();
    }

    @Override
    public List<Product> findAllNameDesc() {
        return productRepository.findAllNameDesc();
    }

    @Override
    public List<Product> findAllPriceDesc() {
        return productRepository.findAllPriceDesc();
    }

    @Override
    public List<Product> findAllQuantityDesc() {
        return productRepository.findAllQuantityDesc();
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return productRepository.search(keyword);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public boolean delete(Integer id) {
        productRepository.deleteById(id);
        return true;
    }
}
