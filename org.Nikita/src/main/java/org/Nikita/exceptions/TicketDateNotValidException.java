package org.Nikita.exceptions;

import java.time.LocalDateTime;

public class TicketDateNotValidException extends RuntimeException{

    public TicketDateNotValidException(LocalDateTime time){
        super(time.toString());
    }

    public TicketDateNotValidException(){}
}
