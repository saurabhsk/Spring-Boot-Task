package com.stackroute.MuzixApp.service.exception;

public class MuzixNotFoundException extends Exception {  ////To handle MuzixNotFoundException

    String message;

    public MuzixNotFoundException(String message) {
        super(message);
        this.message = message;
    }


}
