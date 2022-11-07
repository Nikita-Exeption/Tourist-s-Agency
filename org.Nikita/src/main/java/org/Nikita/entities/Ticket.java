package org.Nikita.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



@Entity(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ticketId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String fromCity;

    @Column(nullable = false)
    private String toCity;

    @Column(nullable = false)
    private LocalDateTime timeLeave;

    @Column(nullable = false)
    private LocalDateTime timeArrive;

    public Ticket() {
    }

    public Ticket(Long ticketId, String name, BigDecimal price, String fromCity, String toCity, LocalDateTime timeLeave, LocalDateTime timeArrive) {
        this.ticketId = ticketId;
        this.name = name;
        this.price = price;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.timeLeave = timeLeave;
        this.timeArrive = timeArrive;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public LocalDateTime getTimeLeave() {
        return timeLeave;
    }

    public void setTimeLeave(LocalDateTime timeLeave) {
        this.timeLeave = timeLeave;
    }

    public LocalDateTime getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(LocalDateTime timeArrive) {
        this.timeArrive = timeArrive;
    }
}
