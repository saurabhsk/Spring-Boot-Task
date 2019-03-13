package com.stackroute.MuzixApp.service.globalController;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handler(Exception ex) {
        return new ResponseEntity<>("Hmm.. Problem Loading page bro/sis:" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
