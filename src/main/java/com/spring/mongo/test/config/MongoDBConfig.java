package com.spring.mongo.test.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.spring.mongo.test.domain.event.repository.EventDocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@RequiredArgsConstructor
@EnableMongoRepositories(basePackageClasses = EventDocRepository.class)
@Configuration
public class MongoDBConfig {

    private final MongoDBProperties mongoDBProperties;

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), mongoDBProperties.getDatabase());
    }

    @Bean
    public MongoClient mongoClient() {
        StringBuilder connectionString = new StringBuilder();
        connectionString.append("mongodb://")
                .append(mongoDBProperties.getUsername()).append(":").append(mongoDBProperties.getPassword())
                .append("@").append(mongoDBProperties.getHost())
                .append(":").append(mongoDBProperties.getPort())
                .append("/").append(mongoDBProperties.getDatabase())
                .append("?authSource=admin")
        ;

        System.out.println(connectionString.toString());

        return MongoClients.create(connectionString.toString());
    }
}
