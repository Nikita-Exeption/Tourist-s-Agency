package org.Nikita.controllers;

import org.Nikita.entities.Ticket;
import org.Nikita.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketController {

    private final TicketService service;

    @Autowired
    public TicketController(TicketService service){
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getAllTickets(){
        return service.getAllTickets();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket createTicket(@RequestBody Ticket ticket){
        return service.createTicket(ticket);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ticket findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> findByName(@RequestParam("name") String name){
        return service.findByName(name);
    }

    @GetMapping("/fromCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> findByFromCity(@RequestParam("fromCity") String fromCity){
        return service.findByFromCity(fromCity);
    }

    @GetMapping("/toCity")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> findByToCity(@RequestParam("toCity") String toCity){
        return service.findByToCity(toCity);
    }


}
