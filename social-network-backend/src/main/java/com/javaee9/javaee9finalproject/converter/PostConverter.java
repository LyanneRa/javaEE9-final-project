package com.javaee9.javaee9finalproject.converter;

import com.javaee9.javaee9finalproject.dto.PostDto;
import com.javaee9.javaee9finalproject.entity.Post;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
@Component
public class PostConverter implements Converter<PostDto, Post>{

    @Override
    public Post fromDtoToEntity(PostDto postDto) {
        return Post.builder()
                .id(postDto.id())
                .header(postDto.header())
                .content(postDto.content())
                .author(postDto.author())
                .creationTimestamp(ZonedDateTime.parse(postDto.creationTimestamp()))
                .updateTimestamp(ZonedDateTime.parse(postDto.updateTimestamp()))
                .build();
    }

    @Override
    public PostDto fromEntityToDto(Post post) {
        return new PostDto(post.getId(),
                post.getHeader(),
                post.getContent(),
                post.getAuthor(),
                post.getCreationTimestamp().toString(),
                post.getUpdateTimestamp().toString());
    }
}
