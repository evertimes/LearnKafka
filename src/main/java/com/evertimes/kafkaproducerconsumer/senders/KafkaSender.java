package com.evertimes.kafkaproducerconsumer.senders;

import com.evertimes.kafkaproducerconsumer.data.BookInfoDto;

public interface KafkaSender {

    void sendMessage(BookInfoDto bookInfo);
}
