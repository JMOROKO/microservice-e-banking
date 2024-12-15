package com.silstechnologie.chatbotservice.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChatAiService {
    private ChatClient chatClient;
    private VectorStore vectorStore;
    @Value("classpath:prompts/prompt-template.st")
    private Resource resource;

    // dans les anciennes version on utilisait directement ChatClient mais maintenant il faut utiliser Chatclient.builder
    public ChatAiService(ChatClient.Builder chatClient, VectorStore vectorStore) {
        this.chatClient = chatClient.build();
        this.vectorStore = vectorStore;
    }

    public String ragChat(String question){
        List<Document> documents =vectorStore.similaritySearch(question);
        List<String> context = documents.stream().map(Document::getContent).toList();
        PromptTemplate promptTemplate = new PromptTemplate(resource);

        Prompt prompt = promptTemplate.create(Map.of("context", context, "question", question));
        return chatClient.prompt(prompt)
                //.user(question)
                .call()
                .content();
    }
}
