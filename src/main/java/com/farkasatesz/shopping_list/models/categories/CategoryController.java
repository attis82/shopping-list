package com.farkasatesz.shopping_list.models.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/search")
    public List<Category> searchCategoriesByQuery(@RequestParam String query) {
        return categoryService.findCategoriesByQuery(query);
    }

    @GetMapping(path = "/check-existence")
    public Boolean checkCategoriesExistence(@RequestParam String categoryName) {
        return categoryService.existsCategoryByName(categoryName);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping(path = "/{categoryId}")
    public Category updateCategory(@PathVariable Integer categoryId, @RequestBody Category category) {
        return categoryService.updateCategory(categoryId, category);
    }

    @DeleteMapping(path = "/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
