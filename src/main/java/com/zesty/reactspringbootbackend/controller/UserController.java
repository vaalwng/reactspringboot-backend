package com.zesty.reactspringbootbackend.controller;

import com.zesty.reactspringbootbackend.db.UserRepository;
import com.zesty.reactspringbootbackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @Slf4j
@RequestMapping(path="api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createUser")
    User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

}
