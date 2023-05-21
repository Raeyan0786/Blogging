package com.example.Blogging.respositories;

import com.example.Blogging.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
