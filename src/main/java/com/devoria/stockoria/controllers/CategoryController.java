package com.devoria.stockoria.controllers;

import com.devoria.stockoria.data.category.CategoryDto;
import com.devoria.stockoria.models.Category;
import com.devoria.stockoria.services.data.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody CategoryDto categoryDto, HttpServletRequest req) {
        return this.categoryService.create(categoryDto, req);
    }

    @GetMapping
    public List<Category> get(HttpServletRequest req) {
        return this.categoryService.findAll(req);
    }
}
