package org.Nikita.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name = "user")
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

    public Long getId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }
}
