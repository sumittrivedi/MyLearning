package com.example.kafka.circulardependency;

import org.springframework.stereotype.Component;

@Component
public class CircularDependencyA {
    public CircularDependencyA() {
        System.out.println("inside constructor A");
    }
}
