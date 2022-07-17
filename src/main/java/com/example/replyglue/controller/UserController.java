package com.example.replyglue.controller;

import com.example.replyglue.model.User;
import com.example.replyglue.model.UserValidator;
import com.example.replyglue.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@Controller
@RequestMapping("/users")
public class UserController {

    //A successful registration action should return HTTP Status code: 201

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.accepted().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return ResponseEntity.accepted().body(userService.getUserById(id));
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    //@ModelAttribute for FormData
    //@RequestBody for XML/JSON
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        UserValidator userValidation = new UserValidator(user);

        if (userService.existsUserByUsername(user.getUsername())) {     //if username is taken
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already in use. Please try again with a different one");
        }

        if (!userValidation.isAbove18()) {          //if user is NOT above 18
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User underage.");
        }

        if (!userValidation.areUserDetailsValid()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Registration Failed! Check Details and try again!");
        }

        userService.saveUser(user);
        return ResponseEntity.created(URI.create("")).body("User registration successful! ID of the new user: " + user.getId());
    }
}
