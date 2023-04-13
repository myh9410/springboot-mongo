package com.spring.mongo.test.domain.event.entity.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
public class EventRequest {
    @NotBlank
    String title;

    String image;
}
