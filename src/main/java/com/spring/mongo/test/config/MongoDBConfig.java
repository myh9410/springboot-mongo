package com.spring.mongo.test.config;


import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@RequiredArgsConstructor
@EnableReactiveMongoRepositories
@Configuration
public class MongoDBConfig extends AbstractReactiveMongoConfiguration {

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

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return mongoDBProperties.getDatabase();
    }
}
