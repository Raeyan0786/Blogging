package com.example.Blogging.contorollers;

import com.example.Blogging.models.User;
import com.example.Blogging.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<String> saveUser(@RequestBody User user){
          userService.saveUser(user);
        return new ResponseEntity<>("User Saved", HttpStatus.CREATED);
    }
//    @PostMapping("/follow/{myId}/{otherId}")
//    public String followUser(@PathVariable Integer myId, @PathVariable Integer otherId)
//    {
//        return userService.followUser( myId, otherId);
//    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId){
        return userService.getUserById(userId);
    }
    @GetMapping("/alluser")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
        //return new ResponseEntity<>(listOfUserDto, HttpStatus.OK);
    }

    @PutMapping("/update-user/{userId}")
    public void updateUser( @RequestBody User user, @PathVariable int userId){
        this.userService.updateUser(user,userId);

    }

}
