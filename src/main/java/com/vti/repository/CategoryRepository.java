package com.vti.repository;

import com.vti.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select i from Category i order by i.id desc ")
    List<Category> findAllIdDesc();

    @Query("select c from Category c order by c.categoryName desc ")
    List<Category> findAllNameDesc();

    @Query("select s from Category s where concat(s.id, '', s.categoryName) like %?1%")
    List<Category> search(String keyword);
}
