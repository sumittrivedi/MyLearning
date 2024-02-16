package com.example.kafka.controller;

import com.example.kafka.kafka.KafkaProducer;
import com.example.kafka.payload.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka Producer");
    }

    @PostMapping("/publish-json")
    public ResponseEntity<String> publish(@RequestBody Employee employee) {
        kafkaProducer.sendJsonPayLoad(employee);
        return ResponseEntity.ok("JSON message sent to Kafka Producer");
    }

}
