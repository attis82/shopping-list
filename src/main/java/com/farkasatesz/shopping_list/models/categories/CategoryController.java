package com.farkasatesz.shopping_list.models.categories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/shopping-list/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/search")
    public List<Category> search(@RequestParam String query) {
        return categoryService.findCategoriesByQuery(query);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping(path = "/{categoryId}")
    public Category update(@PathVariable Integer categoryId, @RequestBody Category category) {
        return categoryService.updateCategory(categoryId, category);
    }

    @DeleteMapping(path = "/{categoryId}")
    public void delete(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
