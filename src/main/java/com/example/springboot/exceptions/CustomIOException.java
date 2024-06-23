package com.example.springboot.exceptions;

public class CustomIOException extends Exception {
    public CustomIOException(String message, Throwable cause) {
        super(message, cause);
    }
}