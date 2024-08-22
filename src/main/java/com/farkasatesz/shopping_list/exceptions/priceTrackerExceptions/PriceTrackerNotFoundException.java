package com.farkasatesz.shopping_list.exceptions.priceTrackerExceptions;

public class PriceTrackerNotFoundException extends RuntimeException {
    public PriceTrackerNotFoundException(String message) {
        super(message);
    }
}
