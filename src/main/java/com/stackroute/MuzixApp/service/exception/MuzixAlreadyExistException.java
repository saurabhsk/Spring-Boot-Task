package com.stackroute.MuzixApp.service.exception;

public class MuzixAlreadyExistException extends Exception {   //To handle MuzixAlreadyExistException

    String message;

    public MuzixAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }


}
