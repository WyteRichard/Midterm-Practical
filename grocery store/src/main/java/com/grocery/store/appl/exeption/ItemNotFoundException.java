package com.grocery.store.appl.exeption;

public class ItemNotFoundException extends Exception{

    public ItemNotFoundException(String message) {
        super(message);
    }
}