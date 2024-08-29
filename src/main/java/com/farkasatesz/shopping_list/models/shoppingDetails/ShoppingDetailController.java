package com.farkasatesz.shopping_list.models.shoppingDetails;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/shopping-details")
public class ShoppingDetailController {
    private final ShoppingDetailService shoppingDetailService;

    @Autowired
    public ShoppingDetailController(ShoppingDetailService shoppingDetailService) {
        this.shoppingDetailService = shoppingDetailService;
    }

    @GetMapping(path = "/{shoppingListId}")
    public List<ShoppingDetail> getShoppingDetail(@PathVariable Integer shoppingListId) {
        return shoppingDetailService.findAllByShoppingListId(shoppingListId);
    }

    @PostMapping
    public ShoppingDetail createShoppingDetail(@RequestBody ShoppingDetail shoppingDetail) {
        return shoppingDetailService.save(shoppingDetail);
    }

    @DeleteMapping(path = "/delete-list/{shoppingListId}")
    public void deleteShoppingList(@PathVariable Integer shoppingListId) {
        shoppingDetailService.deleteList(shoppingListId);
    }

    @DeleteMapping(path = "/{shoppingDetailId}")
    public void deleteShoppingDetail(@PathVariable Integer shoppingDetailId) {
        shoppingDetailService.deleteDetail(shoppingDetailId);
    }

    @Transactional
    @PutMapping(path = "/{shoppingDetailId}")
    public ShoppingDetail update(@RequestBody ShoppingDetail shoppingDetail, @PathVariable Integer shoppingDetailId) {
        return shoppingDetailService.update(shoppingDetailId, shoppingDetail);
    }
}
