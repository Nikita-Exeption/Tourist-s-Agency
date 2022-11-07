package org.Nikita.exceptions;

public class UserPhoneNotValidException extends RuntimeException{

    public UserPhoneNotValidException(String phone){
        super(phone);
    }
}
