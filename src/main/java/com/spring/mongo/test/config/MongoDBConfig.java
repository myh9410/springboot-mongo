package com.spring.mongo.test.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@RequiredArgsConstructor
@Configuration
public class MongoDBConfig {

    private final MongoDBProperties mongoDBProperties;

    @Bean
    public MongoDatabaseFactory mongoDatabaseFactory() {
        StringBuilder connectionString = new StringBuilder();
        connectionString.append("mongodb://").append(mongoDBProperties.getHost())
                .append(":").append(mongoDBProperties.getPort())
                .append("/").append(mongoDBProperties.getDatabase());

        return new SimpleMongoClientDatabaseFactory(connectionString.toString());
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoTemplate().getMongoDatabaseFactory());
    }

}
