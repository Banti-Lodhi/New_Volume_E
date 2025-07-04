package com.microservices.services;

import com.microservices.config.RestTemplateConfig;
import com.microservices.entity.Comments;
import com.microservices.payload.Post;
import com.microservices.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class CommentsServices {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;

    public Comments saveComment(Comments comments) {
        Post post = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8085/api/posts/getPost/" + comments.getPostId(), Post.class);
        if (post != null) {
            Comments save = commentsRepository.save(comments);
            return save;
        } else {
            return null;
        }
    }

    public List<Comments> getAllCommentsByPostId(Long postId) {
        List<Comments> comments = commentsRepository.findByPostId(postId);
        return comments;
    }
}
