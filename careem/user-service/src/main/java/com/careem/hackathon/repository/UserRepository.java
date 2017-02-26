package com.careem.hackathon.repository;

import com.careem.hackathon.api.UserRequest;
import com.careem.hackathon.api.UserResponse;
import com.careem.hackathon.service.core.User;

/**
 * Created by aakash.jindal on 26/02/17.
 */
public interface UserRepository {
    void createUser(UserRequest consignment);
}

