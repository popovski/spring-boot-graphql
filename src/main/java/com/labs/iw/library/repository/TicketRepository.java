package com.labs.iw.library.repository;

import com.labs.iw.library.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
