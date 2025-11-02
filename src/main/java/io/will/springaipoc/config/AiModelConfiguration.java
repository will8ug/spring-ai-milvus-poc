package io.will.springaipoc.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.VectorStoreChatMemoryAdvisor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiModelConfiguration {
    @Bean
    public ChatClient chatClient(ChatModel chatModel, VectorStore vectorStore) {
        VectorStoreChatMemoryAdvisor chatMemoryAdvisor = VectorStoreChatMemoryAdvisor.builder(vectorStore).build();

        return ChatClient.builder(chatModel)
                .defaultAdvisors(chatMemoryAdvisor)
                .build();
    }
}