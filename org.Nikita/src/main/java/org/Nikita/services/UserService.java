package org.Nikita.services;

import org.Nikita.entities.Ticket;
import org.Nikita.entities.User;
import org.Nikita.exceptions.*;
import org.Nikita.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final TicketService ticketService;
    private static final Logger LOG = Logger.getLogger(UserService.class.getName());

    @Autowired
    public UserService(UserRepository userRepository, TicketService ticketService){
        this.userRepository = userRepository;
        this.ticketService = ticketService;
    }

    public List<User> getAllUsers(){
        LOG.info("Get All Users");
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        LOG.info("Get By Id");
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public User createUser(User user){
        if (user.getPhone().matches("^+7[0-9]{8,}+$")){
            LOG.log(Level.WARNING,"Russian's number of phone: " + user.getPhone());
            throw new UserRussianPhoneException();
        }
        if (checkPhone(user.getPhone())){
            LOG.info("Created new user");
            userRepository.save(user);
        }else {
            throw new UserPhoneNotValidException(user.getPhone());
        }
        return user;
    }

    public User findByPhone(String phone){
        LOG.info("get by phone");
        return userRepository.findByPhone(phone).orElseThrow(() -> new UserPhoneExistException(phone));
    }

    public List<Ticket> getTicketsById(Long id){
        LOG.info("get list of tickets from user by id: " + id);
        return getUserById(id).getTickets();
    }

    public List<Ticket> addUserTicket(Long userId, Long ticketId){
        User user = getUserById(userId);
        Ticket ticket = ticketService.findById(ticketId);
        user.getTickets().add(ticket);
        LOG.info("add new ticket by ticketId: " + ticketId + " to list of tickets form user by userId: " + userId);
        return user.getTickets();
    }

    private boolean checkPhone(String phone){
        return phone.matches("^[+][0-9]{8,}$");
    }
}
