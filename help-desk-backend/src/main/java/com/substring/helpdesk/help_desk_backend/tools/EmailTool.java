package com.substring.helpdesk.help_desk_backend.tools;


import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class EmailTool {


    @Tool(description = "Send an email to the support team with the provided email and message.")
    public void sendEmailToSupportTeam(
            @ToolParam(description = "email id associated with the ticket for contact") String email,
           @ToolParam(description = "Short description of ticket summary.") String message){

        System.out.println("Sending email to support team...");
        System.out.println("email: " + email);
        System.out.println("message: " + message);

    }
}
