package com.example.Blogging.respositories;

import com.example.Blogging.models.Post;
import com.example.Blogging.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    //to find all post of an user
    List<Post> findByUser(User user);


    List<Post> findByTitleContaining(String keyword);
}
