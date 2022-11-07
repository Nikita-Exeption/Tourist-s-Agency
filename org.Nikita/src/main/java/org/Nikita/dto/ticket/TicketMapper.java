package org.Nikita.dto.ticket;

import org.Nikita.entities.Ticket;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {
    SimpleTicketDto convertTicketToSimpleTicket(Ticket ticket);
    List<SimpleTicketDto> convertTicketToSimpleTicket(List<Ticket> tickets);
}
