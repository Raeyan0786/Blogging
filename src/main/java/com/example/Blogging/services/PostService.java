package com.example.Blogging.services;


import com.example.Blogging.dto.PostDto;
import com.example.Blogging.models.Post;
import com.example.Blogging.models.User;
import com.example.Blogging.respositories.PostRepo;
import com.example.Blogging.respositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;


    public void createPost(PostDto post, Integer userId) {
        Post newPost = new Post();

        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());
        newPost.setAddedDate(new Date());

        User user = userRepo.findById(userId).get();
        newPost.setUser(user);
        postRepo.save(newPost);

    }

    public void updatePost(Post post, int postId, Integer userId) {
        Post oldPost = postRepo.findById(postId).get();

        oldPost.setTitle(post.getTitle());
        oldPost.setContent(post.getContent());


        postRepo.save(oldPost);
    }
    public PostDto getPost(int postId) {

        Post post= postRepo.findById(postId).get();
        return modelMapper.map(post, PostDto.class);
    }

    public void deletePost(int postId) {
        Post post = postRepo.findById(postId).get();

        postRepo.delete(post);
    }

    public List<PostDto>  getPostsByUser(int userId) {
        User user = userRepo.findById(userId).get();
        List<Post> postList = postRepo.findByUser(user);


        return postList.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }


    public List<PostDto> searchPosts(String keyword) {

        return postRepo.findByTitleContaining(keyword).stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

    }

}
