package com.farkasatesz.shopping_list.exceptions.supermarketExceptions;

public class SupermarketNotFoundException extends RuntimeException {
    public SupermarketNotFoundException(String message) {
        super(message);
    }
}
