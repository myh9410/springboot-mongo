package com.spring.mongo.test.web.controller;

import com.spring.mongo.test.domain.event.entity.EventDoc;
import com.spring.mongo.test.facade.EventFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventFacade eventFacade;

    @GetMapping("/event/{id}")
    public void getEventById(@PathVariable(name = "id") String id) {
        EventDoc eventDoc = eventFacade.getEvent(id);

        System.out.println(eventDoc.toString());
    }

    @PostMapping("/event")
    public void insertEvent() {

        EventDoc eventDoc = EventDoc.builder()
                .id("2")
                .title("title2")
                .image("image2")
                .build();

        eventFacade.insertEvent(eventDoc);
    }

}
