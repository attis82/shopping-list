package com.farkasatesz.shopping_list.exceptions.shoppingDetailExceptions;

public class ShoppingDetailNotFoundException extends RuntimeException {
    public ShoppingDetailNotFoundException(String message) {
        super(message);
    }
}
