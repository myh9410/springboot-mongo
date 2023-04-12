package com.spring.mongo.test;

import com.spring.mongo.test.domain.event.entity.EventDoc;
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

        EventDoc eventDoc =
                EventDoc.builder()
                    .id("id1")
                    .title("title1")
                    .image("image1")
                    .build();

        eventFacade.insertEvent(eventDoc);
    }

}
