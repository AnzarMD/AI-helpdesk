package com.substring.helpdesk.help_desk_backend.service;


import com.substring.helpdesk.help_desk_backend.tools.EmailTool;
import com.substring.helpdesk.help_desk_backend.tools.TicketDatabaseTool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AIService {

    private final TicketDatabaseTool ticketDatabaseTool;

    private final ChatClient chatClient;

    private final EmailTool emailTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systempromptResource;

    public String getResponseFromAssistant(String query, String conversationId) {
        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .tools(ticketDatabaseTool, emailTool)
                .system(systempromptResource)
                .user(query)
                .call()
                .content();
    }

    public Flux<String> streamResponseFromAssistant(String query, String conversationId) {
        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                .tools(ticketDatabaseTool, emailTool)
                .system(systempromptResource)
                .user(query)
                .stream()
                .content();
    }

}
