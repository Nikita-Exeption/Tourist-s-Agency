package org.Nikita.controllers;

import org.Nikita.entities.Ticket;
import org.Nikita.entities.User;
import org.Nikita.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@Validated @RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping("/phone")
    @ResponseStatus(HttpStatus.OK)
    public User getByPhone(@RequestAttribute(name = "phone") String phone){
        return service.findByPhone(phone);
    }

    @GetMapping("/tickets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> getUserTicketById(@PathVariable Long id){
        return service.getTicketsById(id);
    }

    @PostMapping("{id}/tickets/{ticketId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Ticket> addUserTicket(@PathVariable Long id, @PathVariable Long  ticketId){
        return service.addUserTicket(id, ticketId);
    }



}
