package com.example.replyglue.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Could not find User with ID: " + id);
    }
}