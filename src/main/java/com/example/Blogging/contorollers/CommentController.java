package com.example.Blogging.contorollers;

import com.example.Blogging.dto.CommentDto;
import com.example.Blogging.models.Comment;
import com.example.Blogging.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<String> createComment(@RequestBody CommentDto comment,
                                                    @PathVariable int postId){
        commentService.createComment(comment, postId);
        return new ResponseEntity<>("Comment is Ceated", HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable int commentId){
        commentService.deleteComment(commentId);

    }

    @GetMapping("/comments/{commentId}")
    public CommentDto getComment(@PathVariable int commentId){
        return commentService.getComment(commentId);
    }
}
