package org.Nikita.repositories;

import org.Nikita.entities.Ticket;
import org.Nikita.exceptions.TicketNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class TicketRepositoryTest {

    private final TicketRepository repository;

    @Autowired
    TicketRepositoryTest(TicketRepository repository) {
        this.repository = repository;
    }

    private static Ticket ticket;
    private final static String NAME = "Name";
    private final static String FROM_CITY = "From";
    private final static String TO_CITY = "To";
    private final static LocalDateTime LEAVE = LocalDateTime.of(2022, 12, 12, 13, 45);
    private final static LocalDateTime ARRIVE = LocalDateTime.of(2022, 12, 13, 9, 10);

    @BeforeAll
    static void init() {
        ticket = new Ticket(
                NAME,
                BigDecimal.TEN,
                FROM_CITY,
                TO_CITY,
                LEAVE,
                ARRIVE);
    }

    @BeforeEach
    void before(){
        repository.save(ticket);
    }

    @Test
    void findByName() {
        List<Ticket> tickets = repository.findByName(Pageable.ofSize(1), NAME).orElseThrow(TicketNotFoundException::new);

        Ticket result = tickets.get(0);

        assertEquals(NAME, result.getName());
        assertEquals(FROM_CITY, result.getFromCity());
        assertEquals(TO_CITY, result.getToCity());
        assertEquals(ARRIVE, result.getTimeArrive());
        assertEquals(LEAVE, result.getTimeLeave());
    }

    @Test
    void findByFromCity() {
        List<Ticket> tickets = repository.findByFromCity(Pageable.ofSize(1), FROM_CITY).orElseThrow(TicketNotFoundException::new);

        Ticket result = tickets.get(0);

        assertEquals(1, tickets.size());
        assertEquals(NAME, result.getName());
        assertEquals(FROM_CITY, result.getFromCity());
        assertEquals(TO_CITY, result.getToCity());
        findByName();
    }

    @Test
    void findByToCity() {
        List<Ticket> tickets = repository.findByToCity(Pageable.ofSize(1), TO_CITY).orElseThrow(TicketNotFoundException::new);

        Ticket result = tickets.get(0);

        assertEquals(1, tickets.size());
        assertEquals(NAME, result.getName());
        assertEquals(FROM_CITY, result.getFromCity());
        assertEquals(TO_CITY, result.getToCity());
    }

    @Test
    void findByFromCityAndToCity() {
        List<Ticket> tickets = repository.findByFromCityAndToCity(FROM_CITY, TO_CITY).orElseThrow(TicketNotFoundException::new);

        Ticket result = tickets.get(0);

        assertEquals(1, tickets.size());
        assertEquals(NAME, result.getName());
        assertEquals(FROM_CITY, result.getFromCity());
        assertEquals(TO_CITY, result.getToCity());
    }


    @AfterEach
    void after(){
        repository.delete(ticket);
    }
}