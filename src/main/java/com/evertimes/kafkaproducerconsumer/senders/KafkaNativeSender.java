package com.evertimes.kafkaproducerconsumer.senders;

import com.evertimes.kafkaproducerconsumer.data.BookInfoDto;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class KafkaNativeSender {

    KafkaProducer<String, String> producer;

    KafkaNativeSender() {
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "localhost:9093,localhost:9094");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer(kafkaProps);
    }

    public void sendMessage(BookInfoDto bookInfo) {
        ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precission Products",
                                                                     "France");
        try {
            producer.send(record);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessageSync(BookInfoDto bookInfo) {
        ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precission Products",
                                                                     "France");
        try {
            System.out.println(producer.send(record).get().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessageAsync(BookInfoDto bookInfo) {
        ProducerRecord<String, String> record = new ProducerRecord<>("CustomerCountry", "Precission Products",
                                                                     "France");
        try {
            producer.send(record);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
