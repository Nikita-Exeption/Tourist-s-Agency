package org.Nikita.services;

import org.Nikita.entities.Ticket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class TicketServiceTest {

    @Autowired
    private TicketService service;
    private static Ticket ticket;

    @BeforeAll
    static void init(){
        ticket = new Ticket(1L,
                "Name",
                BigDecimal.TEN,
                "From",
                "To",
                LocalDateTime.of(2022, 12, 5, 12, 30),
                LocalDateTime.of(2022, 12, 6, 20, 0));
    }

    @Test
    void getAllTickets() {
        service.createTicket(ticket);
        assertEquals(1, service.getAllTickets().size());
    }

    @Test
    void createTicket() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByFromCity() {
    }

    @Test
    void findByToCity() {
    }

    @Test
    void findTicketFromBetweenTwoTime() {
    }

    @Test
    void findTicketFromCityAndToCity() {
    }
}