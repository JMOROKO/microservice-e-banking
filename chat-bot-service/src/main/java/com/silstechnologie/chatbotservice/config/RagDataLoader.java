package com.silstechnologie.chatbotservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RagDataLoader {
    @Value("classpath:/pdfs/cv.pdf")
    private Resource pdfResource;
    private JdbcClient jdbcClient;
    private VectorStore vectorStore;

    public RagDataLoader(JdbcClient jdbcClient, VectorStore vectorStore) {
        this.jdbcClient = jdbcClient;
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void initStore(){
        Integer count = jdbcClient.sql("select count(*) from vector_store").query(Integer.class).single();
        if(count == 0){
            PagePdfDocumentReader pagePdfDocumentReader = new PagePdfDocumentReader(pdfResource);
            List<Document> documents = pagePdfDocumentReader.get();
            TextSplitter textSplitter = new TokenTextSplitter();
            List<Document> chumks = textSplitter.split(documents);
            vectorStore.accept(chumks);
        }
    }
}
