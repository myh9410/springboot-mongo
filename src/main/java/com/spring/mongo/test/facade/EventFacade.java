package com.spring.mongo.test.facade;

import com.spring.mongo.test.domain.entity.EventDoc;
import com.spring.mongo.test.domain.repository.EventDocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventFacade {

    private MongoTemplate mongoTemplate;
    private EventDocRepository eventDocRepository;

    public EventDoc getEvent(String id) {
        EventDoc eventDoc = mongoTemplate.findById(id, EventDoc.class);

        return Optional.ofNullable(eventDoc).orElseThrow(IllegalArgumentException::new);
    }

    public EventDoc getEventByRepo(String id) {
        return eventDocRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }


    public List<EventDoc> getEventList(String title) {
        Query query = new Query().addCriteria(Criteria.where("title").is(title));

        return mongoTemplate.find(query, EventDoc.class);
    }

    public List<EventDoc> getEventListByRepo(String title) {
        return eventDocRepository.findByTitle(title);
    }

    public EventDoc insertEvent(EventDoc event) {
        return mongoTemplate.insert(event);
    }

    public EventDoc insertEventByRepo(EventDoc event) {
        return eventDocRepository.insert(event);
    }

}
