package com.example.demo.controller;

import com.example.demo.models.ResponseObj;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/Users")
public class userController {
    // dang req: http://localhost:8080/api/v1/Users
    @GetMapping("/getAllUsers")
    List<String> getAllUser(){
        return List.of("hello", "hoi");
    }
    @Autowired
    private UserService userService;

    @PostMapping(value="/register", consumes={"application/json"})
    public ResponseObj register(@RequestBody User user){
        String username = user.getUsername();

        if(userService.existUsername(username)) {
            return new ResponseObj("500", "username exist!",null);
        }
        userService.addUser(user);

        return new ResponseObj("200","register Sucessfully!",user);
    }
    @PostMapping(value="/login", consumes={"application/json"})
    public ResponseObj login(@RequestBody User user){
        String username = user.getUsername();

        if(!userService.existUsername(username)) {
            return new ResponseObj("500", "wrong username or password!",null);
        }
        userService.addUser(user);

        return new ResponseObj("200","login Sucessfully!",user);
    }
}
