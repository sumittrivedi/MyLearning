package com.example.springai;

private final ChatClient chatClient;

PoetryService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
}

String generate() {
    return chatClient
            .prompt("Write a playful haiku about morning coffee following the traditional 5-7-5 syllable structure.")
            .call()
            .content();
}
