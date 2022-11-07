package org.Nikita.exceptions;

public class TicketNotFoundException extends RuntimeException{

    public TicketNotFoundException(long id){
        super(String.valueOf(id));
    }

    public TicketNotFoundException(){}
}
