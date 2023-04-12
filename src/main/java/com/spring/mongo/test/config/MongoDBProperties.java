package com.spring.mongo.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "spring.data.mongodb")
@Configuration
public class MongoDBProperties {
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
