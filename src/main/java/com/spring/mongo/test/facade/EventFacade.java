package com.spring.mongo.test.facade;

import com.mongodb.client.result.DeleteResult;
import com.spring.mongo.test.domain.event.entity.EventDoc;
import com.spring.mongo.test.domain.event.entity.dto.EventRequest;
import com.spring.mongo.test.domain.event.repository.EventDocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventFacade {

    private final MongoTemplate mongoTemplate;
    private final EventDocRepository eventDocRepository;

    public EventDoc getEventById(String id) {
        EventDoc eventDoc = mongoTemplate.findById(id, EventDoc.class);

        return Optional.ofNullable(eventDoc).orElseThrow(IllegalArgumentException::new);
    }

    public EventDoc getEventByTitle(String title) {
        try {
            EventDoc eventDoc = eventDocRepository.findByTitle(title);

            return eventDoc;
        } catch (IncorrectResultSizeDataAccessException irex) {
            throw new IllegalArgumentException("aaaaa");
        }
    }

    public List<EventDoc> getEventList(String title) {
        Query query = new Query().addCriteria(Criteria.where("title").is(title));

        return mongoTemplate.find(query, EventDoc.class);
    }

    public EventDoc insertEvent(EventRequest eventRequest) {
        EventDoc eventDoc = EventDoc.builder()
                .title(eventRequest.getTitle())
                .image(eventRequest.getImage())
                .build();

        return mongoTemplate.insert(eventDoc);
    }

    public void deleteEvent(String title) {
        Query query = new Query().addCriteria(Criteria.where("title").is(title));

        DeleteResult deleteResult = mongoTemplate.remove(query, EventDoc.class);

        System.out.println(query.toString());
        System.out.println("deleted result : " + deleteResult.getDeletedCount());
    }

}
