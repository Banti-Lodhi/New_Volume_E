package com.microservices.controller;

import com.microservices.entity.Comments;
import com.microservices.services.CommentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentsController {
    @Autowired
    private CommentsServices commentsServices;
    //http://localhost8086/api/comments/save
    @PostMapping("/save")
    public ResponseEntity<Comments> saveCommentData(@RequestBody Comments comments) {
        Comments cmts1 = commentsServices.saveComment(comments);
        return new ResponseEntity<>(cmts1, HttpStatus.OK);
    }
    //http://localhost8086/api/comments/postId
    @GetMapping("{postId}")
    public List<Comments> getAllCommentsByPostId(@PathVariable Long postId) {
          List<Comments> comments = commentsServices.getAllCommentsByPostId(postId);
          return comments;
    }
}
