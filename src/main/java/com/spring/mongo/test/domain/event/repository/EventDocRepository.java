package com.spring.mongo.test.domain.event.repository;

import com.spring.mongo.test.domain.event.entity.EventDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventDocRepository extends MongoRepository<EventDoc, String> {

    List<EventDoc> findByTitle(String title);

}
