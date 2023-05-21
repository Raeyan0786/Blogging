package com.example.Blogging.dto;

import com.example.Blogging.models.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    private int postId;
    @NotEmpty(message = "Post Title should not be empty !!!")
    private String title;
    @NotEmpty(message = "Post Content should not be empty !!!")
    private String content;
    private Date addedDate;
    private User user;



    HashSet<CommentDto> commentList = new HashSet<>();
}
