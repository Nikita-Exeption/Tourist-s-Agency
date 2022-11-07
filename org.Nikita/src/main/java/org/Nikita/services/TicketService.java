package org.Nikita.services;

import org.Nikita.dto.ticket.TicketMapper;
import org.Nikita.entities.Ticket;
import org.Nikita.exceptions.TicketDateNotValidException;
import org.Nikita.exceptions.TicketNotFoundException;
import org.Nikita.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketService {

    private final TicketRepository repository;
    private final TicketMapper mapper;
    private static final Logger LOG = Logger.getLogger(TicketService.class.getName());

    @Autowired
    public TicketService(TicketRepository repository, TicketMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Ticket> getAllTickets(){
        LOG.log(Level.INFO, "get all tickets :)");
        Iterable<Ticket> tickets = repository.findAll(PageRequest.of(0, 1, Sort.by("name")));
        List<Ticket> result = new ArrayList<>();
        for (Ticket t : tickets){
            result.add(t);
        }
        return result;
    }

    public Ticket createTicket(Ticket ticket){
        LOG.info("created new ticket: " + ticket);
        if (!validate(ticket)){
            throw new TicketDateNotValidException(ticket.getTimeLeave());
        }
        return repository.save(ticket);
    }

    public Ticket findById(Long id){
        LOG.info("get ticket by id: " + id);
        return repository.findById(id).orElseThrow(() -> new TicketNotFoundException(id));
    }

    public List<Ticket> findByName(String name){
        LOG.info("get ticket by name: " + name);
        return validateListOfTickets(repository.findByName(PageRequest.of(0, 10, Sort.by("name")), name).orElseThrow(TicketNotFoundException::new));
    }

    public List<Ticket> findByFromCity(String fromCity){
        LOG.info("get ticket by from city: " + fromCity);
        return validateListOfTickets(repository.findByFromCity(PageRequest.of(0, 10, Sort.by("fromCity")), fromCity).orElseThrow(TicketNotFoundException::new));
    }

    public List<Ticket> findByToCity(String toCity){
        LOG.info("get list of tickets by to city: " + toCity);
        return validateListOfTickets(repository.findByToCity(PageRequest.of(0, 10, Sort.by("toCity")), toCity).orElseThrow(TicketNotFoundException::new));
    }

    public List<Ticket> findTicketFromBetweenTwoTime(LocalDateTime oneTime, LocalDateTime twoTime){
        LOG.info("get list of tickets between time leave and time arrive: " + oneTime + ", " + twoTime);
        return validateListOfTickets(repository.findByTimeLeaveBetween(oneTime, twoTime).orElseThrow(TicketNotFoundException::new));
    }

    public List<Ticket> findTicketFromCityAndToCity(String fromCity, String toCity){
        return validateListOfTickets(repository.findByFromCityAndToCity(fromCity, toCity).orElseThrow(TicketNotFoundException::new));
    }

    private List<Ticket> validateListOfTickets(List<Ticket> tickets){
        return tickets.stream().filter(this::validate).collect(Collectors.toList());
    }

    private boolean validate(Ticket ticket){
        return ticket.getTimeLeave().isAfter(LocalDateTime.now());
    }



}
