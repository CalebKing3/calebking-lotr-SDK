package com.lordofrings.sdk.exception;

public class MovieNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public MovieNotFoundException(String message) {
        this.message = message;
    }

}
