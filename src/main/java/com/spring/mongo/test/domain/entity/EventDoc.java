package com.spring.mongo.test.domain.entity;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("event")
@Getter
public class EventDoc {
}
