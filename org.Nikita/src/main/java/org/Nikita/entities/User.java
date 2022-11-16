package org.Nikita.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String phone;

//    @Column(nullable = false)
//    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public User(Long userId, String name, String phone, List<Ticket> tickets) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.tickets = tickets;
    }

    public User(String name, String phone, List<Ticket> tickets) {
        this.name = name;
        this.phone = phone;
        this.tickets = tickets;
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User() {
    }

    public Long getId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public String getName() {
        return name;
    }
}
