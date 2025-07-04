package com.microservices.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class postDto {
    private Long postId;
    private String title;
    private String description;
    private String content;
    List<Comment> comments;
}
