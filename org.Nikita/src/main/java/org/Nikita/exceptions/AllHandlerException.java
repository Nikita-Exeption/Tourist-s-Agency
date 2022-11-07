package org.Nikita.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestControllerAdvice
public class AllHandlerException {

    private static final Logger LOG = Logger.getLogger(AllHandlerException.class.getName());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> response(Exception ex) {
        LOG.log(Level.SEVERE, "Unknown error!!!");
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<String> response(TicketNotFoundException e) {
        LOG.log(Level.SEVERE, "Ticket not found exception: " + e.getMessage());
        return new ResponseEntity<>("Ticket " + e.getMessage() + " is not found", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> response(UserNotFoundException e) {
        LOG.log(Level.SEVERE, "User not found exception: " + e.getMessage());
        return new ResponseEntity<>("User " + e.getMessage() + "is not found", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(UserPhoneExistException.class)
    public ResponseEntity<String> response(UserPhoneExistException e) {
        LOG.log(Level.SEVERE, "User not found exception: " + e.getMessage());
        return new ResponseEntity<>("User phone " + e.getMessage() + " is already exist", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserPhoneNotValidException.class)
    public ResponseEntity<String> response(UserPhoneNotValidException e) {
        LOG.log(Level.SEVERE, "User's phone is not valid: " + e.getMessage());
        return new ResponseEntity<>("User's phone is incorrect : " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

