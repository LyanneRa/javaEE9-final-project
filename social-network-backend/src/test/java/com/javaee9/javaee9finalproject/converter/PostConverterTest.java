package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostConverterTest {

    @Autowired
    PostConverter postConverter;

    @Test
    void fromDtoToEntity() {
        ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("Time now is: " + now);
        ZonedDateTime creationTimestamp = ZonedDateTime.now(Clock.systemUTC());
        ZonedDateTime updateTimestamp = ZonedDateTime.now(Clock.systemUTC());
        PostDto postDto = new PostDto(1L,
                "myHeader",
                "content",
                "just me",
                creationTimestamp.toString(),
                updateTimestamp.toString());

        Post entity = postConverter.fromDtoToEntity(postDto);

        Assertions.assertEquals(postDto.header(), entity.getHeader());
        Assertions.assertEquals(creationTimestamp, entity.getCreationTimestamp());
    }

    @Test
    void fromEntityToDto() {
    }
}