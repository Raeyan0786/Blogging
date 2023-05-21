package com.example.Blogging.contorollers;

import com.example.Blogging.dto.PostDto;
import com.example.Blogging.models.Post;
import com.example.Blogging.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;



    @PostMapping("/user/{userId}/posts")
    public ResponseEntity<String> createPost(
            @RequestBody PostDto post,
            @PathVariable Integer userId
            ){

        postService.createPost(post, userId);

        return new ResponseEntity<>("User added post", HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}/post/{postId}")
    public void updatePost(
            @RequestBody Post post,
            @PathVariable Integer userId,
            @PathVariable Integer postId){

        postService.updatePost(post, postId, userId);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPost(
            @PathVariable Integer postId){
        PostDto postDto = postService.getPost(postId);
            return new ResponseEntity<>(postDto, HttpStatus.OK);

    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(@PathVariable Integer postId){

        postService.deletePost(postId);
    }
    //get by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
        List<PostDto> postDtoList = postService.getPostsByUser(userId);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<List<PostDto>> searchPosts(@RequestParam(value = "keyword") String keyword){
       return new ResponseEntity<>(postService.searchPosts(keyword), HttpStatus.OK);

    }
}
