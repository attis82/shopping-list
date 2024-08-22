package com.farkasatesz.shopping_list.models.shoppingItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Integer> {

    @Query("SELECT ShoppingItem FROM ShoppingItem WHERE Supermarket.supermarketId=:supermarketId")
    List<ShoppingItem> findBySupermarketId(Integer supermarketId);

    List<ShoppingItem> findByShoppingItemNameLikeIgnoreCase(String query);
}
