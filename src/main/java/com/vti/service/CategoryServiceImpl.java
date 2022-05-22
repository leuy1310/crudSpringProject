package com.vti.service;

import com.vti.entity.Category;
import com.vti.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> findAllIdDesc() {
        return categoryRepository.findAllIdDesc();
    }

    @Override
    public List<Category> findAllNameDesc() {
        return categoryRepository.findAllNameDesc();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryRepository.search(keyword);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean delete(Integer id) {
        categoryRepository.deleteById(id);
        return false;
    }
}
