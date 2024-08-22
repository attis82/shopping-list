package com.farkasatesz.shopping_list.models.shoppingItems;

import com.farkasatesz.shopping_list.exceptions.shoppingItemExceptions.ShoppingItemException;
import com.farkasatesz.shopping_list.exceptions.shoppingItemExceptions.ShoppingItemNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemService {
    private final ShoppingItemRepository shoppingItemRepository;

    @Autowired
    public ShoppingItemService(ShoppingItemRepository shoppingItemRepository) {
        this.shoppingItemRepository = shoppingItemRepository;
    }

    public List<ShoppingItem> findAllShoppingItemBySupermarket(Integer supermarketId) {
        try {
            return shoppingItemRepository.findBySupermarketId(supermarketId);
        } catch (RuntimeException e) {
            throw new ShoppingItemException("Could not find shopping item by supermarket id: " + supermarketId, e);
        }
    }

    public List<ShoppingItem> findShoppingItemsByQuery(String query){
        try {
            return shoppingItemRepository.findByShoppingItemNameLikeIgnoreCase(query);
        }catch (RuntimeException e){
            throw new ShoppingItemException("Could not find shopping item by query: " + query, e);
        }
    }

    @Transactional
    public ShoppingItem createShoppingItem(ShoppingItem shoppingItem) {
        try {
            shoppingItem.setShoppingItemId(null);
            return shoppingItemRepository.save(shoppingItem);
        }catch (RuntimeException e){
            throw new ShoppingItemException("Could not create shopping item", e);
        }
    }

    @Transactional
    public ShoppingItem updateShoppingItem(Integer shoppingItemId, ShoppingItem shoppingItem) {
        ShoppingItem oldShoppingItem = shoppingItemRepository.findById(shoppingItemId).orElseThrow(() -> new ShoppingItemNotFoundException("Shopping item not found"));
        oldShoppingItem.setShoppingItemName(shoppingItem.getShoppingItemName());
        oldShoppingItem.setCategory(shoppingItem.getCategory());
        oldShoppingItem.setSupermarket(shoppingItem.getSupermarket());
        oldShoppingItem.setUnitType(shoppingItem.getUnitType());
        oldShoppingItem.setPriceTracker(shoppingItem.getPriceTracker());
        try {
            return shoppingItemRepository.save(oldShoppingItem);
        }catch (RuntimeException e){
            throw new ShoppingItemException("Could not update shopping item", e);
        }
    }

    @Transactional
    public void deleteShoppingItem(Integer shoppingItemId) {
        shoppingItemRepository.deleteById(shoppingItemId);
    }
}
