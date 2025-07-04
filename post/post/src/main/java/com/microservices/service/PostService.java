package com.microservices.service;

import com.microservices.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
}
