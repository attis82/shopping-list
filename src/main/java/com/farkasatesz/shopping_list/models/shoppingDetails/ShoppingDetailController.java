package com.farkasatesz.shopping_list.models.shoppingDetails;

import com.farkasatesz.shopping_list.models.shoppingItems.ShoppingItem;
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

    @PostMapping(path = "/add/{shoppingDetailId}")
    public ShoppingDetail addShoppingItem(@PathVariable Integer shoppingDetailId, @RequestBody ShoppingItem shoppingItem) {
        return shoppingDetailService.addItem(shoppingDetailId, shoppingItem);
    }

    @DeleteMapping(path = "/delete-list/{shoppingListId}")
    public void deleteShoppingDetail(@PathVariable Integer shoppingListId) {
        shoppingDetailService.deleteList(shoppingListId);
    }

    @DeleteMapping(path = "/remove?shoppingItemId=shoppingItemId%shoppingListId=shoppingListId")
    public void removeShoppingDetail(@RequestParam Integer shoppingListId, @RequestParam Integer shoppingItemId) {
        shoppingDetailService.removeItem(shoppingListId, shoppingItemId);
    }


}
