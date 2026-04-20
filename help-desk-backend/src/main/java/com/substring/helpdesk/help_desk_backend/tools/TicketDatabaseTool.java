package com.substring.helpdesk.help_desk_backend.tools;


import com.substring.helpdesk.help_desk_backend.entity.Ticket;
import com.substring.helpdesk.help_desk_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;


//    create ticket tool
    @Tool(description = "This tool helps to create new ticket in the database.")
    public Ticket createTicketTool(
           @ToolParam(description = "Ticket details") Ticket ticket
    ) {
        try {
            System.out.println("going to create ticket");
            System.out.println(ticket);
            return ticketService.createTicket(ticket);
        }        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


//    get ticket using username
    @Tool(description = "This tool helps to get the ticket by username.")
    public Ticket getTicketByUserName(
           @ToolParam(description = "email whose ticket is required") String emailid) {
        return ticketService.getTicketByEmailId(emailid);
    }



    @Tool(description = "This tool helps to update the existing ticket in the database.")
    public Ticket updateTicket(
           @ToolParam(description = "New ticket detail with old ticket id") Ticket ticket
    ){
            return ticketService.updateTicket(ticket);
    }

    //get current system time
    @Tool(description = "This tool helps to get the current system time.")
    public String getCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }


}
