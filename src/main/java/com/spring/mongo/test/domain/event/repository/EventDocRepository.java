package com.spring.mongo.test.domain.event.repository;

import com.spring.mongo.test.domain.event.entity.EventDoc;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface EventDocRepository extends MongoRepository<EventDoc, String> {

    EventDoc findByTitle(String title);
}
