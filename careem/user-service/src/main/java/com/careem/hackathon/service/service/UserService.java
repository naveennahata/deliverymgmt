package com.careem.hackathon.service.service;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.service.core.User;
import com.careem.hackathon.api.UserResponse;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public interface UserService {
    UserResponse createUser(UserRequest user);
}
