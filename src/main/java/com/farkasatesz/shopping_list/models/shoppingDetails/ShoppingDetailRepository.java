package com.farkasatesz.shopping_list.models.shoppingDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingDetailRepository extends JpaRepository<ShoppingDetail, Integer> {

    List<ShoppingDetail> findAllByShoppingList_ShoppingListId(Integer shoppingListId);

    void deleteByShoppingList_ShoppingListId(Integer shoppingListId);

}
