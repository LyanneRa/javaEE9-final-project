package com.javaee9.javaee9finalproject.dto;

import java.time.ZonedDateTime;

public record PostDto(
        Long id,
        String header,
        String content,
        String author,
        String creationTimestamp,
        String updateTimestamp) {

}
