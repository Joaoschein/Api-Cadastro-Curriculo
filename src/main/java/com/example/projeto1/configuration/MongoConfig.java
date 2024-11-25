package com.example.projeto1.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    private final MongoClient mongoClient;

    public MongoConfig(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Bean
    public MongoDatabase mongoDatabase() {
        return mongoClient.getDatabase("curriculumsdb");
    }

    @Bean
    public MongoCollection<Document> curriculoCollection(MongoDatabase database) {
        return database.getCollection("curriculos");
    }
}

