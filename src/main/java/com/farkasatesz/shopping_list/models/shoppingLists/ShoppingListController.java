package com.farkasatesz.shopping_list.models.shoppingLists;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/shopping-lists")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListService.findAll();
    }

    @PostMapping
    public ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList) {
        return shoppingListService.createShoppingList(shoppingList);
    }

    @PutMapping(path = "/{shoppingListId}")
    public ShoppingList updateShoppingList(@PathVariable Integer shoppingListId, @RequestBody ShoppingList shoppingList) {
        return shoppingListService.updateShoppingList(shoppingListId, shoppingList);
    }

    @DeleteMapping(path = "/{shoppingListId}")
    public void deleteShoppingList(@PathVariable Integer shoppingListId) {
        shoppingListService.deleteShoppingList(shoppingListId);
    }
}
