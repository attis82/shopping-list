package com.farkasatesz.shopping_list.exceptions.shoppingListExceptions;

public class ShoppingListNotFoundException extends RuntimeException {
    public ShoppingListNotFoundException(String message) {
        super(message);
    }
}
