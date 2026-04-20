package com.substring.helpdesk.help_desk_backend.service;


import com.substring.helpdesk.help_desk_backend.entity.Ticket;
import com.substring.helpdesk.help_desk_backend.repository.TicketRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    //create ticket
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }


    //update ticket
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }


    //get ticket logic
    public Ticket getTicket(Long ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    //by username
    public Ticket getTicketByEmailId(String email) {
        return ticketRepository.findByEmail(email).orElse(null);
    }




}
