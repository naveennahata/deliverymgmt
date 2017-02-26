package com.careem.hackathon.service.service.impl;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.api.UserResponse;
import com.careem.hackathon.repository.UserRepository;
import com.careem.hackathon.service.core.User;
import com.careem.hackathon.service.service.UserService;
import com.google.inject.Inject;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRequest user) {
         userRepository.createUser(user);
    }
}
