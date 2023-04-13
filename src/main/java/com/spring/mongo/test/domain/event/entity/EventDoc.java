package com.spring.mongo.test.domain.event.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@ToString
@Builder
@Getter
@Document("event")
public class EventDoc {

    @Id
    private String _id;

    private String title;

    private String image;

}
