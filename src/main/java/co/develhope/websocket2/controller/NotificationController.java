package co.develhope.websocket2.controller;

import co.develhope.websocket2.entities.ClientMessageDTO;
import co.develhope.websocket2.entities.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class NotificationController {
    @Autowired
    public SimpMessagingTemplate simpMessagingTemplate;
    @PostMapping("/notification")
    public ResponseEntity sendNotificationToClients (@RequestBody MessageDTO messageDTO){
        simpMessagingTemplate.convertAndSend("/topic/greetings",messageDTO);
        return ResponseEntity.accepted().body("Message"+messageDTO.getMessage()+"sent to "+"/topic/broadcast");
    }

    @MessageMapping("/client-message")
    @SendTo("/topic/broadcast")
    public MessageDTO messageFromWebSocket (ClientMessageDTO message){
        return new MessageDTO(message.getClientName(),message.getClientMsg(), message.getClientAlert());
    }
}