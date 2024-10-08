package com.farkasatesz.shopping_list.models.categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByCategoryNameLikeIgnoreCase(String query);
    Boolean existsByCategoryNameLikeIgnoreCase(String categoryName);

}
