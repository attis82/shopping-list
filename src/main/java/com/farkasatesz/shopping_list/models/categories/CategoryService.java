package com.farkasatesz.shopping_list.models.categories;

import com.farkasatesz.shopping_list.exceptions.categoryExceptions.CategoryException;
import com.farkasatesz.shopping_list.exceptions.categoryExceptions.CategoryNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findCategoriesByQuery(String query) {
        try{
            return categoryRepository.findByCategoryNameLikeIgnoreCase(query);
        }catch(Exception e){
            throw new CategoryException("Failed to find categories by query: " + query, e);
        }
    }

    @Transactional
    public Category saveCategory(Category category) {
        try{
            category.setCategoryId(null);
            return categoryRepository.save(category);
        }catch (Exception e){
            throw new CategoryException("Failed to save category: " + category, e);
        }
    }

    @Transactional
    public void deleteCategory(Integer categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
        }catch (Exception e){
            throw new CategoryException("Failed to delete category: " + categoryId, e);
        }
    }

    @Transactional
    public Category updateCategory(Integer categoryId, Category category) {
        try {
            Category categoryToUpdate = categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
            categoryToUpdate.setCategoryName(category.getCategoryName());
            return categoryRepository.save(categoryToUpdate);
        } catch (RuntimeException e) {
            throw new CategoryException("Failed to update category: " + category, e);
        }
    }
}
