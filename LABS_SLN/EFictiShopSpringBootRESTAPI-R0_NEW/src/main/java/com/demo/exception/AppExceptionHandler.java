package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Message> handleException(Exception ex){
        Message err = new Message();
        err.setMessage(ex.getMessage());
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Message> handleProductExistException(EmployeeException ex){
        Message err = new Message();
        err.setMessage(ex.getMessage());
        err.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        err.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
