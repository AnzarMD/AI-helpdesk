package com.substring.helpdesk.help_desk_backend.controller;


import com.substring.helpdesk.help_desk_backend.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/helpdesk")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class AiController {

    private final AIService aiService;


    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query,
                                              @RequestHeader("ConversationId") String conversationId
                                              ) {
        String response = aiService.getResponseFromAssistant(query, conversationId);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/stream")
    public Flux<String> streamResponse(@RequestBody String query,
                                       @RequestHeader("ConversationId") String conversationId
    ) {
        return this.aiService.streamResponseFromAssistant(query, conversationId);
    }


}
