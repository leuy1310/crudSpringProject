package com.vti.service;

import com.vti.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProduct();

    Product getById(Integer id);

    List<Product> findAllIdDesc();

    List<Product> findAllNameDesc();

    List<Product> findAllPriceDesc();

    List<Product> findAllQuantityDesc();

    List<Product> searchProduct(String keyword);

    Product create(Product product);

    void save(Product product);

    boolean delete(Integer id);
}
