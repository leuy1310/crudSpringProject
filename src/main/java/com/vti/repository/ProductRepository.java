package com.vti.repository;

import com.vti.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select i from Product i ORDER BY i.id DESC ")
    List<Product> findAllIdDesc();

    @Query("select n from Product n ORDER BY n.productName DESC ")
    List<Product> findAllNameDesc();

    @Query("select p from Product p ORDER BY p.price DESC ")
    List<Product> findAllPriceDesc();

    @Query("select q from Product q ORDER BY q.quantity DESC ")
    List<Product> findAllQuantityDesc();

    //search
    @Query("select p FROM Product p WHERE concat(p.id,'',p.productName, '',p.price,'',p.quantity ) like %?1%")
    List<Product> search(String keyword);
}
