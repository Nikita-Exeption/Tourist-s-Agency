package org.Nikita.exceptions;

public class UserPhoneExistException extends RuntimeException {

    public UserPhoneExistException(String phone){
        super(phone);
    }
}
