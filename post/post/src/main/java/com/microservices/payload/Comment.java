package com.microservices.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Long commentId;
    private String name;
    private String email;
    private String body;
    private Long postId;
}

