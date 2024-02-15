package com.example.s24742_librarymanagement.expection;

public class ValidationException extends RuntimeException {
    public ValidationException(String message){
        super(message);
    }
}
