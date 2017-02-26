package com.careem.hackathon.controller;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.api.UserResponse;
import com.careem.hackathon.service.service.UserService;
import com.google.inject.Inject;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(UserRequest userRequest) {
         userService.createUser(userRequest);
    }
}
