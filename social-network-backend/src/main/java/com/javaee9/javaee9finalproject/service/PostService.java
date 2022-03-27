package com.javaee9.javaee9finalproject.service;

import com.javaee9.javaee9finalproject.entity.Post;
import com.javaee9.javaee9finalproject.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.List;

@Service
@Slf4j
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> readRecentPosts(){
        ZonedDateTime now = ZonedDateTime.now(Clock.systemUTC());
        ZonedDateTime boundary = now.minusDays(1);

        return readRecentPost(boundary);
    }
    public List<Post> readRecentPost(ZonedDateTime boundary){
        var result = postRepository.queryAllRecentPosts(boundary);
        log.debug("result: {}", result);
        log.info("number of read posts: [{}]", result.size());
        return postRepository.queryAllRecentPosts(boundary);
    }
}
