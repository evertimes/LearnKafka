package com.evertimes.kafkaproducerconsumer.senders;

import com.evertimes.kafkaproducerconsumer.data.BookInfoDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("template")
public class KafkaTemplateSender implements KafkaSender{

    @Override
    public void sendMessage(BookInfoDto bookInfo) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
