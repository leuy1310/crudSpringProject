package com.vti.controller;

import com.vti.dto.ProductDTO;
import com.vti.entity.Category;
import com.vti.entity.Product;
import com.vti.service.CategoryService;
import com.vti.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/list")
    public String getProducts(Model model) {

        List<Product> products = productService.getProduct();
        List<ProductDTO> productDTOS = modelMapper.map(products, new TypeToken<List<ProductDTO>>() {
        }.getType());

        model.addAttribute("productList", productDTOS);
        return "product-list";
    }
    @GetMapping("/list-id")
    public String getProductByIdDesc(Model model) {
        List<Product> getProductByIdDesc = productService.findAllIdDesc();
        List<ProductDTO> productDTOS = modelMapper.map(getProductByIdDesc, new TypeToken<List<ProductDTO>>() {
        }.getType());
        model.addAttribute("productList", productDTOS);
        return "product-list";
    }

    @GetMapping("/list-name")
    public String getProductByNameDesc(Model model) {
        List<Product> getProductByNameDesc = productService.findAllNameDesc();
        List<ProductDTO> productDTOS = modelMapper.map(getProductByNameDesc, new TypeToken<List<ProductDTO>>() {
        }.getType());
        model.addAttribute("productList", productDTOS);
        return "product-list";
    }

    @GetMapping("/list-price")
    public String getProductByPriceDesc(Model model) {
        List<Product> getProductByPriceDesc = productService.findAllPriceDesc();
        List<ProductDTO> productDTOS = modelMapper.map(getProductByPriceDesc, new TypeToken<List<ProductDTO>>() {
        }.getType());
        model.addAttribute("productList", productDTOS);
        return "product-list";
    }

    @GetMapping("/list-quantity")
    public String getProductByQuantityDesc(Model model) {
        List<Product> getProductByQuantityDesc = productService.findAllQuantityDesc();
        List<ProductDTO> productDTOS = modelMapper.map(getProductByQuantityDesc, new TypeToken<List<ProductDTO>>() {
        }.getType());
        model.addAttribute("productList", productDTOS);
        return "product-list";
    }

    // search
    @GetMapping("/search")
    public String search(Model model,@RequestParam("keyword") String keyword) {
        List<Product> search = productService.searchProduct(keyword);
        List<ProductDTO> productDTOS = modelMapper.map(search, new TypeToken<List<ProductDTO>>() {
        }.getType());
        model.addAttribute("productList", productDTOS);
        return "product-list";
    }

    @GetMapping("/create")
    public String create() {
        return "product-create";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute Product product, @RequestParam("categoryId") Integer categoryId) {
        Category category = categoryService.getById(categoryId);
        product.setCategory(category);
        productService.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        Product product = productService.getById(id);
        Category category = categoryService.getById(product.getCategory().getId());
        model.addAttribute("product", product);
        model.addAttribute("category", category);
        return "product-update";
    }

    @PostMapping("update-product")
    public String updateProduct(@ModelAttribute("product") Product product,
                                @RequestParam("categoryId") Integer categoryId) {
        Category category = categoryService.getById(categoryId);
        Product product1 = productService.getById(product.getId());
        product1.setCategory(category);
        product1.setProductName(product.getProductName());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        productService.save(product1);
        return "redirect:/product/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productService.delete(id);
        return "redirect:/product/list";
    }

}
