package com.farkasatesz.shopping_list.models.shoppingDetails;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingDetailRepository extends JpaRepository<ShoppingDetail, Integer> {

    List<ShoppingDetail> findAllByShoppingList_ShoppingListId(Integer shoppingListId);

    void deleteByShoppingList_ShoppingListId(Integer shoppingListId);

    @Query("SELECT sd FROM ShoppingDetail sd WHERE sd.shoppingList.shoppingListId = :shoppingListId AND sd.shoppingItem.shoppingItemId = :shoppingItemId")
    List<ShoppingDetail> findShoppingDetailToDelete(@Param("shoppingListId") Integer shoppingListId, @Param("shoppingItemId") Integer shoppingItemId, Pageable pageable);

}
