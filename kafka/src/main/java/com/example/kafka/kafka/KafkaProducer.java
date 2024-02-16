package com.example.kafka.kafka;

import com.example.kafka.payload.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired private KafkaTemplate<String, Employee> kafkaJsonTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    public void sendMessage(String message) {
        LOGGER.info("Message from Producer : {}", message);
        kafkaTemplate.send("myKafkaTopic", message);
    }

    public void sendJsonPayLoad(Employee employee) {
        LOGGER.info("Message from Producer : {}", employee.toString());
        Message<Employee> message = MessageBuilder.withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
                .build();
        kafkaJsonTemplate.send(message);
    }
}