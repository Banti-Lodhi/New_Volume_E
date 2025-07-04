package com.microservices.controller;

import com.microservices.entity.Post;
import com.microservices.payload.postDto;
import com.microservices.service.PostService;
import com.microservices.service.PostServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final PostServices postServices;
    public PostController(PostService postService, PostServices postServices) {
        this.postService = postService;
        this.postServices = postServices;
    }

    @PostMapping("/savePost")
    public ResponseEntity<Post> savePosts(@RequestBody Post post) {
        Post newPost = postServices.savePost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    @GetMapping("/getPost/{id}")
    public ResponseEntity<ResponseEntity<Optional<Post>>> getPost(@PathVariable Long id) {
       return ResponseEntity.ok(postServices.getPost(id));
    }


    @PostMapping("/Create")
    public ResponseEntity<Post>  createPost(@RequestBody Post post) {
            return ResponseEntity.ok(postService.createPost(post));
    }
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @GetMapping("/{postId}/comments")
    public ResponseEntity<postDto> getPostWithComments(@PathVariable Long postId) {
       postDto postComment = postServices.getPostWithComments(postId);
       return new ResponseEntity<>(postComment, HttpStatus.OK);
    }
}
