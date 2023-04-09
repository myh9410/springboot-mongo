package com.spring.mongo.test.domain.repository;

import com.spring.mongo.test.domain.entity.EventDoc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventDocRepository extends MongoRepository<EventDoc, String> {

    List<EventDoc> findByTitle(String title);

}
