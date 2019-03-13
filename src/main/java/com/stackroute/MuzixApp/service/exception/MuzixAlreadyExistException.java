package com.stackroute.MuzixApp.service.exception;

public class MuzixAlreadyExistException extends Exception {

    String message;

    public MuzixAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }


}
