package com.farkasatesz.shopping_list.models.shoppingLists;

import com.farkasatesz.shopping_list.exceptions.shoppingListExceptions.ShoppingListException;
import com.farkasatesz.shopping_list.exceptions.shoppingListExceptions.ShoppingListNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;

    @Autowired
    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingList> findAll() {
        return shoppingListRepository.findAll();
    }

    public ShoppingList findById(Integer id) {
        return shoppingListRepository.findById(id).orElseThrow(() -> new ShoppingListNotFoundException("Shopping List Not Found"));
    }

    @Transactional
    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    @Transactional
    public ShoppingList updateShoppingList(Integer id, ShoppingList shoppingList) {
        ShoppingList shoppingListToUpdate = findById(id);
        try {
            shoppingListToUpdate.setShoppingListName(shoppingList.getShoppingListName());
            return shoppingListRepository.save(shoppingListToUpdate);
        }catch (Exception e) {
            throw new ShoppingListException("Shopping List Not Found", e);
        }
    }

    @Transactional
    public void deleteShoppingList(Integer id) {
        try {
            shoppingListRepository.deleteById(id);
        }catch (Exception e) {
            throw new ShoppingListException("Shopping List Not Found", e);
        }
    }
}
