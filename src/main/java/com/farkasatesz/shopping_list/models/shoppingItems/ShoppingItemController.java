package com.farkasatesz.shopping_list.models.shoppingItems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/shopping-list/shopping-items")
public class ShoppingItemController {

    private final ShoppingItemService shoppingItemService;

    @Autowired
    public ShoppingItemController(ShoppingItemService shoppingItemService) {
        this.shoppingItemService = shoppingItemService;
    }

    @GetMapping(path = "/search")
    public List<ShoppingItem> getShoppingItemsByQuery(@RequestParam String query) {
        return shoppingItemService.findShoppingItemsByQuery(query);
    }

    @GetMapping(path = "/{supermarketId}")
    public List<ShoppingItem> getShoppingItemsBySupermarketId(@PathVariable Integer supermarketId) {
        return shoppingItemService.findAllShoppingItemBySupermarket(supermarketId);
    }

    @PostMapping
    public ShoppingItem createShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        return shoppingItemService.createShoppingItem(shoppingItem);
    }

    @PutMapping(path = "/{shoppingItemId}")
    public ShoppingItem updateShoppingItem(@PathVariable Integer shoppingItemId, @RequestBody ShoppingItem shoppingItem) {
        return shoppingItemService.updateShoppingItem(shoppingItemId, shoppingItem);
    }

    @DeleteMapping(path = "/{shoppingItemId}")
    public void deleteShoppingItem(@PathVariable Integer shoppingItemId) {
        shoppingItemService.deleteShoppingItem(shoppingItemId);
    }
}
