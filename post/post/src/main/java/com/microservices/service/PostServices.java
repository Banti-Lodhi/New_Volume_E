package com.microservices.service;

import com.microservices.config.RestTemplateConfig;
import com.microservices.entity.Post;
import com.microservices.entityDto.PostDto;
import com.microservices.payload.postDto;
import com.microservices.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PostServices {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplateConfig restTemplate;

    public Post savePost(Post post) {
        Post savePost = postRepository.save(post);
        return savePost;
    }

    public ResponseEntity<Optional<Post>> getPost(Long id) {
        return ResponseEntity.ok(postRepository.findById(id));
        
    }

    public postDto getPostWithComments(Long postId) {
        Post post = postRepository.findById(postId).get();
        ArrayList comment = restTemplate.getRestTemplate().getForObject("http://localhost:8086/api/comments/" + postId, ArrayList.class);
        postDto postDto = new postDto();

        postDto.setPostId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setComments(comment);
        return postDto;
    }
}
