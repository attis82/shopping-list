package com.farkasatesz.shopping_list.exceptions.categoryExceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
