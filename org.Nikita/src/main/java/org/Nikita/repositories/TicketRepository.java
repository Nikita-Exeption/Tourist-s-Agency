package org.Nikita.repositories;

import org.Nikita.entities.Ticket;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends PagingAndSortingRepository<Ticket, Long> {

    Optional<List<Ticket>> findByName(Pageable pageable, String name);
    Optional<List<Ticket>> findByFromCity(Pageable pageable, String fromCity);
    Optional<List<Ticket>> findByToCity(Pageable pageable, String toCity);
    Optional<List<Ticket>> findByFromCityAndToCity(String fromCity, String toCity);
    Optional<List<Ticket>> findByTimeLeaveBetween(LocalDateTime oneTime, LocalDateTime twoTime);
}
