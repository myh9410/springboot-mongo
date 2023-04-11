package com.spring.mongo.test.infrastructure.event;

import com.spring.mongo.test.domain.event.EventDoc;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.List;

public interface EventDocRepository extends ReactiveMongoRepository<EventDoc, String> {

    List<EventDoc> findByTitle(String title);

}
