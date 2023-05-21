package com.example.Blogging.services;

import com.example.Blogging.models.User;
import com.example.Blogging.respositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    public void saveUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).get();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void updateUser(User userD, int userId) {
        User user = userRepo.findById(userId).get();
        user.setName(userD.getName());
        user.setAbout(userD.getAbout());
        user.setEmail(userD.getEmail());
        this.userRepo.save(user);
    }


}
