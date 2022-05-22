package com.vti.service;

import com.vti.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategory();

    Category getById(Integer id);

    List<Category> findAllIdDesc();

    List<Category> findAllNameDesc();

    List<Category> search(String keyword);

    Category create(Category category);

    void update(Category category);

    boolean delete(Integer id);
}
