package com.farkasatesz.shopping_list.models.shoppingDetails;

import com.farkasatesz.shopping_list.exceptions.shoppingDetailExceptions.ShoppingDetailException;
import com.farkasatesz.shopping_list.exceptions.shoppingDetailExceptions.ShoppingDetailNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

        return shoppingDetailRepository.findById(id).orElseThrow(() -> new ShoppingDetailNotFoundException("Could not find shopping detail with id: " + id));

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
    public void deleteDetail(Integer shoppingDetailId) {
        try {
            shoppingDetailRepository.deleteById(shoppingDetailId);
        }catch (Exception e) {
            throw new ShoppingDetailException("Unable to delete shopping details", e);
        }
    }

    @Transactional
    public ShoppingDetail update(Integer shoppingDetailId, ShoppingDetail shoppingDetail) {
        try {
            ShoppingDetail shoppingDetailToUpdate = findById(shoppingDetailId);
            shoppingDetailToUpdate.setShoppingList(shoppingDetail.getShoppingList());
            shoppingDetailToUpdate.setShoppingItem(shoppingDetail.getShoppingItem());
            shoppingDetailToUpdate.setQuantity(shoppingDetail.getQuantity());
            shoppingDetailToUpdate.setLatestUnitPrice(shoppingDetail.getLatestUnitPrice());
            return shoppingDetailRepository.save(shoppingDetailToUpdate);
        }catch (Exception e) {
            throw new ShoppingDetailException("Unable to update shopping details", e);
        }
    }

}
