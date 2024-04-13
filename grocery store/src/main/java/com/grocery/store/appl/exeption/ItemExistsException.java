package com.grocery.store.appl.exeption;

public class ItemExistsException extends Exception{
    public ItemExistsException(String message) {
        super(message);
    }
}