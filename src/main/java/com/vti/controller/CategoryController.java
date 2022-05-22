package com.vti.controller;

import com.vti.dto.CategoryDTO;
import com.vti.entity.Category;
import com.vti.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/list")
    public String getCategory(Model model) {
        List<Category> categories = categoryService.getCategory();
        List<CategoryDTO> categoryDTOS = modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {}.getType());
        model.addAttribute("category", categoryDTOS);
        return "category-list";
    }

    @GetMapping("/list-id")
    public String getCategoryByIdDesc(Model model) {
        List<Category> categories = categoryService.findAllIdDesc();
        List<CategoryDTO> categoryDTOS = modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {}.getType());
        model.addAttribute("category", categoryDTOS);
        return "category-list";
    }

    @GetMapping("/list-name")
    public String getCategoryByNameDesc(Model model) {
        List<Category> categories = categoryService.findAllNameDesc();
        List<CategoryDTO> categoryDTOS = modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {}.getType());
        model.addAttribute("category", categoryDTOS);
        return "category-list";
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        List<Category> categories = categoryService.search(keyword);
        List<CategoryDTO> categoryDTOS = modelMapper.map(categories, new TypeToken<List<CategoryDTO>>() {}.getType());
        model.addAttribute("category", categoryDTOS);
        return "category-list";
    }

    @GetMapping("/create")
    public String create() {
        return "category-create";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.create(category);
        return "redirect:/category/list";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "category-update";
    }

    @PostMapping("updateCategory")
    public String updateCategory(@ModelAttribute Category category) {
        Category category1 = categoryService.getById(category.getId());
        category1.setCategoryName(category.getCategoryName());
        categoryService.update(category);
        return "redirect:/category/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return "redirect:/category/list";
    }
}
