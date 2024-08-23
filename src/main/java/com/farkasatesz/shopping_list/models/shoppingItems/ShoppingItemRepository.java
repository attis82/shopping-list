package com.farkasatesz.shopping_list.models.shoppingItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Integer> {

    List<ShoppingItem> findAllBySupermarketSupermarketId(Integer supermarketId);

    List<ShoppingItem> findByShoppingItemNameLikeIgnoreCase(String query);
}
