package com.example.kafka.kafka;

import com.example.kafka.payload.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "myKafkaTopic", groupId = "groupId")
    public void consumeMessage(String message) {
        LOGGER.info("Message received to Consumer : {}", message);
    }

    @KafkaListener(topics = "jsonTopic", groupId = "groupId")
    public void consumeJsonMessage(Employee employee) {
        LOGGER.info("Message received to Consumer : {}", employee.toString());
    }
}