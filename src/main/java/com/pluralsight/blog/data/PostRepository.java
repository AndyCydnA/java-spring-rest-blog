package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Author;
import com.pluralsight.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    // New method which allows for searching of posts at /posts/search, or posts/search/findByTitleContaining?title=xxx
    // The @RestResource annotation shortens the url for searching, so we can instead use
    // /posts/search/containsTitle?title=xxx
    @RestResource(rel="contains-title",path="containsTitle")
    List<Post> findByTitleContaining(String title);

    // method to search posts by author last name, /posts/search/findByAuthor_Lastname?lastname=Holderness
    List<Post> findByAuthor_Lastname(String lastname);
}