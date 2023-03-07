package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Author;
import com.pluralsight.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Prevent browsing of authors - they will only be visible through a Post (i.e. a blog post will still show author)
@RepositoryRestResource(exported = false)
public interface AuthorRepository extends JpaRepository<Author, Long> {
}