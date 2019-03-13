package com.stackroute.MuzixApp.service.exception;

public class MuzixNotFoundException extends Exception {

    String message;

    public MuzixNotFoundException(String message) {
        super(message);
        this.message = message;
    }


}
