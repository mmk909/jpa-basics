package com.example.crud.exceptions;

public class NoEntityException extends Exception {
    public NoEntityException(Class objectClass, Long id) {
        super(objectClass.getSimpleName() + " with id: " + id + " does not exist.");
    }
}
