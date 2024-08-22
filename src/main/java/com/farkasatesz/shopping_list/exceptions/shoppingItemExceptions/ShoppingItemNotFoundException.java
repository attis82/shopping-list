package com.farkasatesz.shopping_list.exceptions.shoppingItemExceptions;

public class ShoppingItemNotFoundException extends RuntimeException {
    public ShoppingItemNotFoundException(String message) {
        super(message);
    }
}
