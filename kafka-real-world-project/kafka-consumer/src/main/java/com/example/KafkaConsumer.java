package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired private WikiMediaRepository wikiMediaRepository;

    @KafkaListener(topics = "wikimedia", groupId = "groupId")
    public void consumeMessage(String data) {
        LOGGER.info("Data received from producer {}", data);
        WikiMediaEntity wikiMediaEntity = new WikiMediaEntity();
        wikiMediaEntity.setId(90L);
        wikiMediaEntity.setData(data);
        wikiMediaRepository.save(wikiMediaEntity);
    }
}
