package com.evertimes.kafkaproducerconsumer.rest;

import com.evertimes.kafkaproducerconsumer.data.BookInfoDto;
import com.evertimes.kafkaproducerconsumer.senders.KafkaNativeSender;
import com.evertimes.kafkaproducerconsumer.service.KafkaSendingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sending")
public class NativeSendingController {

    private final KafkaNativeSender sender;

    public NativeSendingController(KafkaNativeSender sender) {
        this.sender = sender;
    }


    @PostMapping("/send-message")
    private ResponseEntity<String> sendMessage(@RequestBody BookInfoDto bookInfoDto) {
        sender.sendMessage(bookInfoDto);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/send-message-sync")
    private ResponseEntity<String> sendMessageSync(@RequestBody BookInfoDto bookInfoDto) {
        sender.sendMessageSync(bookInfoDto);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/send-message-async")
    private ResponseEntity<String> sendMessageAsync(@RequestBody BookInfoDto bookInfoDto) {
        sender.sendMessageAsync(bookInfoDto);
        return ResponseEntity.ok("OK");
    }

}
