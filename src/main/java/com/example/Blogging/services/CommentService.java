package com.example.Blogging.services;

import com.example.Blogging.dto.CommentDto;
import com.example.Blogging.dto.PostDto;
import com.example.Blogging.models.Comment;
import com.example.Blogging.models.Post;
import com.example.Blogging.respositories.CommentRepo;
import com.example.Blogging.respositories.PostRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;


    public CommentDto getComment(int commentId) {
        Comment com=commentRepo.findById(commentId).get();

        return modelMapper.map(com, CommentDto.class);
    }


    public void createComment(CommentDto commentD, int postId) {
        Comment comment = new Comment();
        comment.setContent(commentD.getContent());
        Post post = postRepo.findById(postId).get();

        comment.setPost(post);
        commentRepo.save(comment);

    }


    public void deleteComment(int commentId) {
        Comment comment = commentRepo.findById(commentId).get();

        commentRepo.delete(comment);
    }
}
