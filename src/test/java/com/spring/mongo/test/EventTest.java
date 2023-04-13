package com.spring.mongo.test;

import com.spring.mongo.test.domain.event.entity.dto.EventRequest;
import com.spring.mongo.test.facade.EventFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventTest {

    @Autowired
    private EventFacade eventFacade;

    @Test
    void insetEvent() {

        EventRequest eventRequest = EventRequest.builder()
                .title("title999")
                .image("image999")
                .build();

        eventFacade.insertEvent(eventRequest);
    }

}
