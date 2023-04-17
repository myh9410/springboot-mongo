package com.spring.mongo.test.web.controller;

import com.spring.mongo.test.domain.event.entity.EventDoc;
import com.spring.mongo.test.domain.event.entity.dto.EventRequest;
import com.spring.mongo.test.facade.EventFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventFacade eventFacade;

    @GetMapping("/event/{id}")
    public void getEventById(@PathVariable(name = "id") String id) {
        //id가 EventDoc entity의 id가 아니라 _id(ObjectId) 값임
        EventDoc eventDoc = eventFacade.getEventById(id);

        System.out.println(eventDoc.toString());
    }

    @GetMapping("/events")
    public void getAllEventsWithTitle() {
        List<EventDoc> eventDoc = eventFacade.getEventList("title1");

        System.out.println(eventDoc.toString());
    }

    @GetMapping("/events/titles/{title}")
    public void getSingleEventByTitle() {
        EventDoc eventDoc = eventFacade.getEventByTitle("title1");

        System.out.println(eventDoc.toString());
    }

    @PostMapping("/event")
    public void insertEvent(@RequestBody EventRequest eventRequest) {
        eventFacade.insertEvent(eventRequest);
    }

    @DeleteMapping("/events/{title}")
    public void deleteEventByTitle(@PathVariable(name = "title") String title) {
        eventFacade.deleteEvent(title);
    }
}
