package com.farkasatesz.shopping_list.models.shoppingDetails;

import com.farkasatesz.shopping_list.exceptions.shoppingDetailExceptions.ShoppingDetailException;
import com.farkasatesz.shopping_list.exceptions.shoppingDetailExceptions.ShoppingDetailNotFoundException;
import com.farkasatesz.shopping_list.models.shoppingItems.ShoppingItem;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingDetailService {

    private final ShoppingDetailRepository shoppingDetailRepository;

    @Autowired
    public ShoppingDetailService(ShoppingDetailRepository shoppingDetailRepository) {
        this.shoppingDetailRepository = shoppingDetailRepository;
    }

    @Transactional
    public ShoppingDetail save(ShoppingDetail shoppingDetail) {
        try {
            return shoppingDetailRepository.save(shoppingDetail);
        } catch (Exception e) {
            throw new ShoppingDetailException("Unable to save", e);
        }
    }

    public List<ShoppingDetail> findAllByShoppingListId(Integer shoppingListId) {
        try {
            return shoppingDetailRepository.findAllByShoppingList_ShoppingListId(shoppingListId);
        } catch (Exception e) {
            throw new ShoppingDetailException("Unable to find shopping details", e);
        }
    }

    public ShoppingDetail findById(Integer id) {
        return shoppingDetailRepository.findById(id).orElseThrow(() -> new ShoppingDetailNotFoundException("Unable to find shopping details"));
    }

    @Transactional
    public void deleteList(Integer shoppingListId) {
        try {
            shoppingDetailRepository.deleteByShoppingList_ShoppingListId(shoppingListId);
        } catch (Exception e) {
            throw new ShoppingDetailException("Unable to delete shopping details", e);
        }
    }

    @Transactional
    public ShoppingDetail addItem(Integer shoppingDetailId, ShoppingItem shoppingItem) {
        try {
            ShoppingDetail shoppingDetail = new ShoppingDetail();
            ShoppingDetail detailToUpdate = findById(shoppingDetailId);
            shoppingDetail.setShoppingDetailId(null);
            shoppingDetail.setShoppingList(detailToUpdate.getShoppingList());
            shoppingDetail.setShoppingItem(shoppingItem);
            return shoppingDetailRepository.save(shoppingDetail);
        } catch (Exception e) {
            throw new ShoppingDetailException("Unable to add item", e);
        }
    }

    @Transactional
    public void removeItem(Integer shoppingItemId, Integer shoppingListId) {
        Pageable pageable = PageRequest.of(0, 1);  // No need for explicit cast
        List<ShoppingDetail> details = shoppingDetailRepository.findShoppingDetailToDelete(shoppingListId, shoppingItemId, pageable);

        if (!details.isEmpty()) {
            ShoppingDetail detailToDelete = details.get(0);
            shoppingDetailRepository.deleteById(detailToDelete.getShoppingDetailId());
        } else {
            throw new ShoppingDetailNotFoundException("No ShoppingDetail found with shoppingListId " + shoppingListId + " and shoppingItemId " + shoppingItemId);
        }
    }
}
