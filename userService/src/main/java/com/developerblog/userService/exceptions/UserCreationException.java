package com.developerblog.userService.exceptions;

public class UserCreationException extends RuntimeException{
    private String message;

    public UserCreationException(String message) {
        super(message);
    }
}
