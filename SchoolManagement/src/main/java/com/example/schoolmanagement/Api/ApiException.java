package com.example.schoolmanagement.Api;

public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}
